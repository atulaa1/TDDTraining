import org.junit.*;
import org.mockito.ArgumentCaptor;

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
        bankAccountService = new  BankAccountService();
    }

    @Test
    public void TestOpenAccount() {
        bankAccountService.openAccount("22288");
        // mock argument
        ArgumentCaptor<BankAccount> argumentCaptor = ArgumentCaptor.forClass(BankAccount.class);
        verify(mockBankAccountDAO).save(argumentCaptor);
        Assert.assertEquals(argumentCaptor.getValue().getNumberAccount(),"22288");

    }
}
