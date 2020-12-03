/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksys;

import java.util.Date;

/**
 *
 * @author minenice
 */
public class Record {
    private Date date;
    private String operation;
    private double amount;
    private String atmId;

    public Record(String operation, double amount, String atmId) {
        this.date = new Date();
        this.operation = operation;
        this.amount = amount;
        this.atmId = atmId;
    }
    
    public Record(Record other) {
        this.date = other.date;
        this.operation = other.operation;
        this.amount = other.amount;
        this.atmId = other.atmId;
    }

    public Date getDate() {
        return date;
    }

    public String getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }

    public String getAtmId() {
        return atmId;
    }

    @Override
    public String toString() {
        String out = "";
        out += String.format("Date: %s", date);
        out += String.format("Operation: %s", operation);
        out += String.format("amount: %.2f", amount);
        out += String.format("ID: %s", atmId);
        return out;
    }

    public boolean equals(Record obj) {
     return this.date.equals(obj.date) &&
             this.operation.equals(obj.operation) &&
             this.amount == obj.amount &&
             this.atmId.equals(obj.atmId);
    }
}
