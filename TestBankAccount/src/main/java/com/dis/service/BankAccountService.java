package com.dis.service;

import com.dis.dao.BankAccountDAO;
import com.dis.model.BankAccount;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/18/13
 * Time: 1:47 PM
 */
public class BankAccountService {

    private BankAccountDAO bankAccountDAO;

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

    public BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }
}
