package com.dis.dao;

import com.dis.model.BankAccount;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/12/13
 * Time: 2:09 PM
 */
public class BankAccountDAO {
    // open new account
    public int createAccount(BankAccount account) {
        // code execute with DB
        return 0;
    }

    public void withdraw(int money) {
        // insert code here
        // code execute with DB

    }

    public void deposit(int money) {
        // insert code here
        // code execute with DB
    }

    public BankAccount getAccount(String accountNumber) {
        // code execute with DB
        return new BankAccount();
    }


}
