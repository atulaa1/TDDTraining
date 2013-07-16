package com.dis.service;

import com.dis.dao.BankAccountDAO;
import com.dis.model.BankAccount;

import java.util.Date;

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
}
