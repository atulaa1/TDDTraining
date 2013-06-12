package com.dis.model;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/12/13
 * Time: 1:49 PM
 */
public class BankAccount {
    private String accountNumber;
    private int balance;
    private Timestamp createDate;

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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
