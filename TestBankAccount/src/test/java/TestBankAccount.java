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
        bankAccountService.openAccount("22288");
        bankAccountService.deposit("22288",30,"Test deposit");
        BankAccount account = new BankAccount();
        account.setAccountNumber("22288");
        account.setBalance(30);
        when(bankAccountService.getAccount("22288")).thenReturn(account);
        ArgumentCaptor<BankAccount> argumentCaptor = ArgumentCaptor.forClass(BankAccount.class);
        verify(mockBankAccountDAO).update(argumentCaptor.capture());
        Assert.assertEquals("22288", account.getAccountNumber());
        Assert.assertEquals(30, account.getBalance());
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


}
