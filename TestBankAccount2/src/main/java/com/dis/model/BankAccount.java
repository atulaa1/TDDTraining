package com.dis.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dungpx
 * Date: 7/16/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount
{
    private String accountNumber;
    private int balance;

    public Date getOpenDate()
    {
        return openDate;
    }

    public void setOpenDate(Date openDate)
    {
        this.openDate = openDate;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    private Date openDate;
}
