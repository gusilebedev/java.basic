public class Transactions implements Runnable {
    private Bank bank;

    private Account fromAccount;

    private Account toAccount;

    private long amount;

    public Transactions(Bank bank, Account fromAccount, Account toAccount, long amount) {
        this.bank = bank;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            bank.transfer(fromAccount.getAccNumber(), toAccount.getAccNumber(), amount);
            bank.transfer(toAccount.getAccNumber(), fromAccount.getAccNumber(), amount);
        }
    }
}