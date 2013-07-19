package com.dis.dao;

import com.dis.model.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dungpx
 * Date: 7/17/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDAO
{
    public void save(Transaction transaction)
    {
        // perform save transaction
    }

    public List<Transaction> findByAccountNumber(String accountNumber)
    {
        // get all transaction of this account
        return null;
    }

    public List<Transaction> getTransactionsByTime(String accountNumber, Date start, Date end)
    {
        return  null;
    }

    public List<Transaction> getRecent(int numberTransactions)
    {
        return null;
    }
}
