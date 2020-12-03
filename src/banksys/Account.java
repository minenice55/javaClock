/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksys;

/**
 *
 * @author minenice
 */
public class Account {
    private char type;
    private double balance;
    private User owner;

    public Account() {
        this.type = 'c';
        this.balance = 0;
        this.owner = null;
    }
    
    public Account(User owner) {
        this.type = 'c';
        this.balance = 0;
        this.owner = owner;
    }

    public Account(char type, User owner) {
        this.type = type;
        this.balance = 0;
        this.owner = owner;
    }
    
    public Account(Account other) {
        this.type = other.type;
        this.balance = other.balance;   //hol the fuck up
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    @Override
    public String toString() {
        return String.format("account type %c, balance %.2f", type, balance);
    }

    public boolean equals(Account other) {
        return this.type == other.type &&
                this.balance == other.balance &&
                this.owner.equals(other.getOwner());
    }
}
