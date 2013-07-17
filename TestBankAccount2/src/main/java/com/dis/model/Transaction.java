package com.dis.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dungpx
 * Date: 7/17/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction
{
    private String accountNumber;
    private Date timeExecute;
    private int amount;
    private String description;

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public Date getTimeExecute()
    {
        return timeExecute;
    }

    public void setTimeExecute(Date timeExecute)
    {
        this.timeExecute = timeExecute;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
