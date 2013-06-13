package com.dis.service;

import com.dis.dao.BankAccountDAO;
import com.dis.model.BankAccount;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/13/13
 * Time: 1:44 PM
 */
public class BankAccountService {
    private BankAccountDAO bankAccountDAO;

    public void openAccount(String numberAccount)
    {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(numberAccount);
        bankAccount.setBalance(0);
        bankAccountDAO.createAccount(bankAccount);
    }
}
