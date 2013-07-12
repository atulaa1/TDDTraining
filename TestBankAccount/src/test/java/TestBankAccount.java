import com.dis.dao.BankAccountDAO;
import com.dis.dao.TransactionDAO;
import com.dis.model.BankAccount;
import com.dis.model.Transaction;
import com.dis.service.BankAccountService;
import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import java.util.*;

import static org.mockito.Mockito.*;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/13/13
 * Time: 1:57 PM
 */
public class TestBankAccount {

    public BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    public TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    public BankAccountService bankAccountService;
    @Before
    public void setUp()
    {
        // prepare data for test
        bankAccountService = new  BankAccountService();
        // inject mock dao to service
        bankAccountService.setBankAccountDAO(mockBankAccountDAO);
        bankAccountService.setTransactionDAO(mockTransactionDAO);

    }

    @Test
    public void testOpenAccount() {
        bankAccountService.openAccount("22288");
        // mock argument
        ArgumentCaptor<BankAccount> argumentCaptor = ArgumentCaptor.forClass(BankAccount.class);
        verify(mockBankAccountDAO).save(argumentCaptor.capture());
        Assert.assertEquals(argumentCaptor.getValue().getAccountNumber(),"22288");
        Assert.assertEquals(0,argumentCaptor.getValue().getBalance());

    }

    @Test
    public void testGetAccount() {
        BankAccount account = bankAccountService.getAccount("22288");
        verify(mockBankAccountDAO).get("22288");

    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount();
        account.setAccountNumber("22288");
        account.setBalance(30);
        when(mockBankAccountDAO.get("22288")).thenReturn(account);
        bankAccountService.deposit("22288",2,"Test deposit");
        ArgumentCaptor<BankAccount> argumentCaptor = ArgumentCaptor.forClass(BankAccount.class);
        verify(mockBankAccountDAO).update(argumentCaptor.capture());
        Assert.assertEquals("22288", account.getAccountNumber());
        Assert.assertEquals(32, account.getBalance());
    }

    @Test
    public void testDepositWithTransaction() {
        bankAccountService.deposit("22288",88,"Test deposit and save transaction", new Date());
        ArgumentCaptor<BankAccount> argumentCaptor = ArgumentCaptor.forClass(BankAccount.class);
        ArgumentCaptor<Transaction> argumentCaptorTransaction = ArgumentCaptor.forClass(Transaction.class);
        InOrder orders = inOrder(mockBankAccountDAO,mockTransactionDAO);
        // verify the order of DAOs
        orders.verify(mockTransactionDAO).save(argumentCaptorTransaction.capture());
        orders.verify(mockBankAccountDAO).update(argumentCaptor.capture());

    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount();
        account.setAccountNumber("22288");
        account.setBalance(30);
        when(mockBankAccountDAO.get("22288")).thenReturn(account);
        bankAccountService.withdraw("22288",22,"Test withdraw an account", new Date());
        ArgumentCaptor<String> argumentCaptorGetAccount = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<BankAccount> argumentCaptorSaveAccount = ArgumentCaptor.forClass(BankAccount.class);
        ArgumentCaptor<Transaction> argumentCaptorTransaction = ArgumentCaptor.forClass(Transaction.class);
        InOrder orders = inOrder(mockBankAccountDAO,mockTransactionDAO);
        // verify the order of DAOs

        orders.verify(mockBankAccountDAO).get(argumentCaptorGetAccount.capture());
        orders.verify(mockTransactionDAO).save(argumentCaptorTransaction.capture());
        orders.verify(mockBankAccountDAO).update(argumentCaptorSaveAccount.capture());
        Assert.assertEquals(8,argumentCaptorSaveAccount.getValue().getBalance());
    }

    @Test
    public void testGetTransactionsOccurred() {
        bankAccountService.getTransactionsOccurred("22288");
        ArgumentCaptor<String> argumentAccount = ArgumentCaptor.forClass(String.class);
        verify(mockTransactionDAO).findByAccountNumber(argumentAccount.capture());
        Assert.assertEquals("22288",argumentAccount.getValue());
    }

    @Test
    public void testGetTransactionsInDurationTime() {
        Date fromDate = new Date("07/08/2013");
        Date endDate =  new Date("07/11/2013");
        bankAccountService.getTransactionsOccurred("22288",fromDate, endDate);
        ArgumentCaptor<String> accountNumber = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Date> fromDateMock = ArgumentCaptor.forClass(Date.class);
        ArgumentCaptor<Date> endDateMock = ArgumentCaptor.forClass(Date.class);
        verify(mockTransactionDAO).findByAccountNumberAndTime(accountNumber.capture(),fromDateMock.capture(),endDateMock.capture());
        Assert.assertEquals(0,fromDateMock.getValue().compareTo(fromDate));
        Assert.assertEquals(0,endDateMock.getValue().compareTo(endDate));
    }

    @Test
    public void testRecentTransactions() {
        bankAccountService.getRecentTransaction(2);
        ArgumentCaptor<Integer> numberLatest = ArgumentCaptor.forClass(Integer.class);
        verify(mockTransactionDAO).getRecent(numberLatest.capture());
    }


}
