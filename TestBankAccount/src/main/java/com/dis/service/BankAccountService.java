package com.dis.service;

import com.dis.dao.BankAccountDAO;
import com.dis.dao.TransactionDAO;
import com.dis.model.BankAccount;
import com.dis.model.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/18/13
 * Time: 1:47 PM
 */
public class BankAccountService {

    private BankAccountDAO bankAccountDAO;

    public TransactionDAO getTransactionDAO() {
        return transactionDAO;
    }

    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    private TransactionDAO transactionDAO;

    public void openAccount(String accountNumber) {
        BankAccount account = new BankAccount();
        Date now = new Date();
        account.setAccountNumber(accountNumber);
        account.setBalance(0);
        account.setOpenTime(now);

        getBankAccountDAO().save(account);
    }

    public BankAccount getAccount(String accountNumber) {
        return bankAccountDAO.get(accountNumber);
    }

    public BankAccount deposit(String numberAccount, int amount, String description) {
        BankAccount account = bankAccountDAO.get(numberAccount);
        account.setAccountNumber(numberAccount);
        account.setBalance(account.getBalance() + amount);
        return bankAccountDAO.update(account);
    }

    public BankAccount deposit(String numberAccount, int amount, String description, Date date) {
        BankAccount account = bankAccountDAO.get(numberAccount);
        account.setAccountNumber(numberAccount);
        account.setBalance(account.getBalance() + amount);
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(numberAccount);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setTimeExecute(date);
        transactionDAO.save(transaction);
        return bankAccountDAO.update(account);
    }

    public BankAccount withdraw(String numberAccount, int amount, String description, Date date) {
        BankAccount account = bankAccountDAO.get(numberAccount);
        account.setBalance(account.getBalance()- amount);
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(numberAccount);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setTimeExecute(date);
        transactionDAO.save(transaction);
        return bankAccountDAO.update(account);
    }

    public List<Transaction> getTransactionsOccurred(String accountNumber) {
        return transactionDAO.findByAccountNumber(accountNumber);
    }

    public List<Transaction> getTransactionsOccurred(String accountNumber, Date from , Date to) {
        return transactionDAO.findByAccountNumberAndTime(accountNumber,from,to);
    }

    public List<Transaction> getRecentTransaction(int numberTransactions) {
        return transactionDAO.getRecent(numberTransactions);
    }

    public BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }
}
