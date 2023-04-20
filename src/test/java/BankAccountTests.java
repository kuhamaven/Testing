import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTests {

    BankAccount account;

    @Before
    public void initialize(){
        account = new BankAccount("Khalil Stessens");
    }

    @Test
    public void testBankAccountGetsCreatedSuccesfully(){
        Assert.assertEquals("Khalil Stessens",account.getOwner());
    }

    @Test (expected = RuntimeException.class)
    public void extractingNegativeMoneyThrowsRuntimeException(){
        account.extractMoney(-100);
    }

    @Test
    public void extractingMoneyWithEnoughBalanceShouldWork(){
        account.addMoney(1000);
        account.extractMoney(100);
    }
}
