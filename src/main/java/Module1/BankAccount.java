package Module1;

public class BankAccount {

    private float balance;
    private String owner;

    public BankAccount(String owner){
        this.owner = owner;
        balance = 0;
    }

    public void addMoney(float moneyToAdd){
        if(moneyToAdd<0) throw new RuntimeException("Can't add negative money!");
        balance += moneyToAdd;
    }

    public void extractMoney(float moneyToExtract){
        if(moneyToExtract<0 || balance-moneyToExtract<0) throw new RuntimeException("Can't extract negative money!");
        balance -= moneyToExtract;
    }

    public void transfer(BankAccount target, float amount){
        try{
            extractMoney(amount);
        } catch (RuntimeException e){
            throw new RuntimeException("Not enough money for this transfer!");
        } finally {
            target.addMoney(amount);
        }
    }

    public float getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
}
