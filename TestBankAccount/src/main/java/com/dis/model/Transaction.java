package com.dis.model;

import java.util.Date;

/**
 * User: dungpx
 * Date: 6/27/13
 * Time: 1:32 PM
 */
public class Transaction {
    private String accountNumber;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
    private int amount;
    private Date timeExecute;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimeExecute() {
        return timeExecute;
    }

    public void setTimeExecute(Date timeExecute) {
        this.timeExecute = timeExecute;
    }
}
