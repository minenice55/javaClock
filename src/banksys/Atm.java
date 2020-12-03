/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksys;

import java.util.Scanner;


/**
 *
 * @author minenice
 */
public class Atm {
    private String atmId;
    static int nextId;

    public Atm() {
        this.atmId = String.format("%08d", nextId++);
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public boolean equals(Atm other) {
        return this.atmId.equals(other.atmId);
    }

    @Override
    public String toString() {
        return String.format("ATM Id: %s", atmId);
    }
    
    public void printWelcome() {
        
    }
    
    public boolean inputPin() {
        return false;
    }
    
    public int chooseAcc() {
        return 0;
    }
    
    public boolean withdraw(Account account) {
        User user = account.getOwner();
        Scanner input = new Scanner(System.in);
        
        System.out.println("how much:");
        double amount = input.nextDouble();
        
        if (account.getBalance() < amount) {
            System.out.println("sorry nothing");
            return false;
        }
        
        account.setBalance(account.getBalance() - amount);
        System.out.println("ok i'll");
        user.getHistory().add(new Record("withdraw", amount, atmId));
        return true;
    }
    
    public boolean deposit(Account account) {
        User user = account.getOwner();
        Scanner input = new Scanner(System.in);
        
        System.out.println("how much:");
        double amount = input.nextDouble();
        
        account.setBalance(account.getBalance() + amount);
        System.out.println("ok i'll");
        user.getHistory().add(new Record("deposit", amount, atmId));
        return true;
    }
    
    public User readUserId() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter user ID:");
        String id = input.next();
        
        for (int i = 0; i < Bank.getUsers().size(); i++) {
            User user = Bank.getUsers().get(i);
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        
        return null;
    }
    
    public boolean inputPin(User user) {
        Scanner input = new Scanner(System.in);
        int maxTries = 3;
        
        for (int i = 0; i < maxTries; i++) {
            System.out.println("Enter user Password:");
            String pass = input.next();
            if (user.getPin().equals(pass))
                return true;
        }
        
        return false;
    }
    
    public Account chooseAcc(User user) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Choose an account:");
        int acc = input.nextInt();
        
        return acc == 1 ? user.getCheckingAccount() : user.getSavingsAccount();
    }
    
    public int chooseOp() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Choose an operation:");
        int op = input.nextInt();
        
        return op;
    }
    
    public void displayBal(Account account) {
        System.out.printf("balance is: %.2f\n", account.getBalance());
    }
    
    public void printBye() {
        System.out.println("fuck off now~");
    }
    
    public void printHello() {
        System.out.println("give us ur money");
    }
    
    public boolean wantsContinue() {
        Scanner input = new Scanner(System.in);
        System.out.print("quit terminal? (1 = yes, 0 = no) ");
        int in = input.nextInt();
        return in != 1;
    }
    
    public void pipeline() {
        printHello();
        User user = readUserId();
        if (user == null)
            System.exit(1); //nonexistant user
        if (!inputPin(user))
            System.exit(2); //wrong pass
        
        Account account = chooseAcc(user);
        do {
            int op = chooseOp();
            switch (op) {
                case 1:
                    withdraw(account);
                    break;
                case 2:
                    deposit(account);
                    break;
                default:
                    displayBal(account);
            }
        } while (wantsContinue());
        printBye();
    }
}