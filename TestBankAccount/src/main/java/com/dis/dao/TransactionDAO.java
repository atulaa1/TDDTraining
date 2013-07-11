package com.dis.dao;

import com.dis.model.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: dungpx
 * Date: 6/27/13
 * Time: 1:45 PM
 */
public class TransactionDAO {
    public void save(Transaction transaction)
    {

    }
    public List<Transaction> findByAccountNumber(String accountNumber)
    {
        return  new ArrayList<Transaction>();
    }
    public List<Transaction> findByAccountNumberAndTime(String accountNumber, Date from, Date to) {
        // find by from DB base on conditions
        return new ArrayList<Transaction>();
    }
    public List<Transaction> getRecent(int numberTransactions) {
        // get n transactions latest from DB
        return new ArrayList<Transaction>();
    }
}

