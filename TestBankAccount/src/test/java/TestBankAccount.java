import com.dis.dao.BankAccountDAO;
import com.dis.model.BankAccount;
import com.dis.service.BankAccountService;
import org.junit.*;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/13/13
 * Time: 1:57 PM
 */
public class TestBankAccount {

    public BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    public BankAccountService bankAccountService;
    @Before
    public void setUp()
    {
        // prepare data for test
        bankAccountService = new  BankAccountService();
        // inject mock dao to service
        bankAccountService.setBankAccountDAO(mockBankAccountDAO);

    }

    @Test
    public void testOpenAccount() {
        bankAccountService.openAccount("22288");
        // mock argument
        ArgumentCaptor<BankAccount> argumentCaptor = ArgumentCaptor.forClass(BankAccount.class);
        verify(mockBankAccountDAO).save(argumentCaptor.capture());
        Assert.assertEquals(argumentCaptor.getValue().getAccountNumber(),"22288");

    }

    @Test
    public void testGetAccount() {
        BankAccount account = bankAccountService.getAccount("22288");

        verify(mockBankAccountDAO).get("22288");

    }
}
