/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksys;

import java.util.ArrayList;

/**
 *
 * @author minenice
 */
public class User {
    private String userId;
    private String userName;
    private String pin;
    private Account checkingAccount;
    private Account savingsAccount;
    private ArrayList<Record> history;
    static int nextId;

    public User(String userName, String pin) {
        this.userId = String.format("%08d", nextId++);
        this.userName = userName;
        this.pin = pin;
        this.checkingAccount = new Account('c', this);
        this.savingsAccount = new Account('s', this);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Account getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(Account checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(Account savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public ArrayList<Record> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Record> history) {
        this.history = history;
    }
}
