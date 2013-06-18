package com.dis.model;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/18/13
 * Time: 1:47 PM
 */
public class BankAccount {
    private String accountNumber;
    private int balance;
    private Date openTime;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }
}
