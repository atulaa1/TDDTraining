package com.dis.service;

import com.dis.dao.BankAccountDAO;
import com.dis.dao.TransactionDAO;
import com.dis.model.BankAccount;
import com.dis.model.Transaction;

import java.util.Date;

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
        account.setAccountNumber(accountNumber);
        account.setBalance(0);
        getBankAccountDAO().save(account);
    }

    public BankAccount getAccount(String accountNumber) {
        return bankAccountDAO.get(accountNumber);
    }

    public BankAccount deposit(String numberAccount, int amount, String description) {
        BankAccount account = new BankAccount();
        account.setAccountNumber(numberAccount);
        account.setBalance(amount);
        return bankAccountDAO.update(account);
    }

    public BankAccount deposit(String numberAccount, int amount, String description, Date date) {
        BankAccount account = new BankAccount();
        account.setAccountNumber(numberAccount);
        account.setBalance(amount);
        Transaction transaction = new Transaction();
        transaction.setAccountNumber(numberAccount);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setTimeExecute(date);
        transactionDAO.save(transaction);
        return bankAccountDAO.update(account);
    }

    public BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }
}
