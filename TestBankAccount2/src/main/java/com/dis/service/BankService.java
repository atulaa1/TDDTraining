package com.dis.service;

import com.dis.dao.BankAccountDAO;
import com.dis.dao.TransactionDAO;
import com.dis.model.BankAccount;
import com.dis.model.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dungpx
 * Date: 7/16/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankService
{
    private BankAccountDAO bankAccountDAO;
    private TransactionDAO transactionDAO;

    public TransactionDAO getTransactionDAO()
    {
        return transactionDAO;
    }

    public void setTransactionDAO(TransactionDAO transactionDAO)
    {
        this.transactionDAO = transactionDAO;
    }

    public BankAccountDAO getBankAccountDAO()
    {
        return bankAccountDAO;
    }

    public void setBankAccountDAO(BankAccountDAO bankAccountDAO)
    {
        this.bankAccountDAO = bankAccountDAO;
    }

    public void openAccount(String accountNumber)
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setBalance(0);
        bankAccount.setOpenDate(new Date());
        bankAccountDAO.save(bankAccount);

    }
    public BankAccount getAccount(String accountNumber)
    {
        return bankAccountDAO.get(accountNumber);
    }
    public void deposit(String accountNumber, int amount, String description)
    {
        BankAccount account = bankAccountDAO.get(accountNumber);
        account.setBalance(account.getBalance() + amount);
        bankAccountDAO.save(account);
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(accountNumber);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setTimeExecute(new Date());
        transactionDAO.save(transaction);
    }

    public void withdraw(String accountNumber, int amount, String description)
    {
        BankAccount account = bankAccountDAO.get(accountNumber);
        account.setBalance(account.getBalance() - amount);
        bankAccountDAO.save(account);
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(accountNumber);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setTimeExecute(new Date());
        transactionDAO.save(transaction);
    }

    public List<Transaction> getTransactionsOccurred(String accountNumber)
    {
        return transactionDAO.findByAccountNumber(accountNumber);
    }

    public List<Transaction> getTransactionsByTime(String accountNumber, Date start, Date end)
    {
        return transactionDAO.getTransactionsByTime(accountNumber,start,end);
    }
    public List<Transaction> getTransactionRecent(int numberTransaction)
    {
        return transactionDAO.getRecent(numberTransaction);
    }
}
