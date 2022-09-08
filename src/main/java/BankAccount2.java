public class BankAccount2 {

    private float balance;
    private String owner;

    public BankAccount2(String owner){
        this.owner = owner;
        balance = 0;
    }

    public void addMoney(float moneyToAdd){
        if(moneyToAdd<0) throw new RuntimeException("Can't add negative money!");
        balance += moneyToAdd;
    }

    public void extractMoney(float moneyToExtract){
        if(moneyToExtract<0) throw new RuntimeException("Can't extract negative money!");
        if(balance-moneyToExtract<0) throw new RuntimeException("Not enough money!");
        balance -= moneyToExtract;
    }

    public void transfer(BankAccount2 target, float amount){
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
