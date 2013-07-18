package com.dis.test;

import com.dis.dao.BankAccountDAO;
import com.dis.dao.TransactionDAO;
import com.dis.model.BankAccount;
import com.dis.model.Transaction;
import com.dis.service.BankService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: dungpx
 * Date: 7/16/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankServiceTest
{
    public BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    public TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    public BankService bankService;

    @Before
    public void SetUp()
    {
        bankService = new BankService();
        bankService.setBankAccountDAO(mockBankAccountDAO);
        bankService.setTransactionDAO(mockTransactionDAO);

    }

    @Test
    public void testOpenAccount()
    {
        bankService.openAccount("8888");
        ArgumentCaptor<BankAccount> account = ArgumentCaptor.forClass(BankAccount.class);
        verify(mockBankAccountDAO).save(account.capture());
        Assert.assertEquals(0,account.getValue().getBalance());
    }

    @Test
    public void testGetAccount()
    {
        bankService.getAccount("8888");
        ArgumentCaptor<String> accountNumber = ArgumentCaptor.forClass(String.class);
        verify(mockBankAccountDAO).get(accountNumber.capture());
    }

    @Test
    public void testDeposit()
    {

        BankAccount accountStub = new BankAccount();
        accountStub.setAccountNumber("8888");
        accountStub.setBalance(30);
        when(mockBankAccountDAO.get("8888")).thenReturn(accountStub);
        // note: need to stub before call method service
        bankService.deposit("8888",8,"Test deposit");
        InOrder checkOrder = inOrder(mockBankAccountDAO, mockTransactionDAO);
        ArgumentCaptor<BankAccount> account = ArgumentCaptor.forClass(BankAccount.class);
        ArgumentCaptor<Transaction> transaction = ArgumentCaptor.forClass(Transaction.class);
        checkOrder.verify(mockBankAccountDAO).get("8888");
        checkOrder.verify(mockBankAccountDAO).save(account.capture());
        checkOrder.verify(mockTransactionDAO).save(transaction.capture());

        Assert.assertEquals(38,account.getValue().getBalance());
    }
    
    @Test
    public void testWithdraw() 
    {
        BankAccount account = new BankAccount();
        account.setAccountNumber("8888");
        account.setBalance(30);
        when(mockBankAccountDAO.get("8888")).thenReturn(account);
        bankService.withdraw("8888",5,"Test withdraw");
        InOrder order = inOrder(mockBankAccountDAO,mockTransactionDAO);
        ArgumentCaptor<BankAccount> accountCaptor = ArgumentCaptor.forClass(BankAccount.class);
        ArgumentCaptor<Transaction> transactionCaptor = ArgumentCaptor.forClass(Transaction.class);
        // check order of DAOs
        order.verify(mockBankAccountDAO).get("8888");
        order.verify(mockBankAccountDAO).save(accountCaptor.capture());
        order.verify(mockTransactionDAO).save(transactionCaptor.capture());
        Assert.assertEquals(25,accountCaptor.getValue().getBalance());
    }

    @Test
    public void testGetTransactions()
    {
        bankService.getTransactionsOccurred("8888");
        // how to define signature DAO's method
        ArgumentCaptor<String> accountNumber = ArgumentCaptor.forClass(String.class);
        verify(mockTransactionDAO).findByAccountNumber(accountNumber.capture());
        Assert.assertEquals("8888",accountNumber.getValue());
    }

}
