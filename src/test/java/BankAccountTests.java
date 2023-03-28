import org.junit.Assert;
import org.junit.Test;

public class BankAccountTests {

    @Test
    public void testBankAccountGetsCreatedSuccesfully(){
        BankAccount bankAccount = new BankAccount("Khalil Stessens");
        Assert.assertEquals("Khalil Stessens",bankAccount.getOwner());
    }

    @Test (expected = RuntimeException.class)
    public void extractingNegativeMoneyThrowsRuntimeException(){
        BankAccount account = new BankAccount("Poor");
        account.extractMoney(-100);
    }

    @Test
    public void extractingMoneyWithEnoughBalanceShouldWork(){
        BankAccount account = new BankAccount("Rich");
        account.addMoney(1000);
        account.extractMoney(100);
    }
}
