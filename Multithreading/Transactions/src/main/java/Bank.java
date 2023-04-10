import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public class Bank {
    public ConcurrentMap<String, Account> accounts = new ConcurrentHashMap<>();
    private final Random random = new Random();
    private static long verificationLimit = 50000;

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        if(fromAccountNum.compareTo(toAccountNum) > 0) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    if (fromAccount.isBlocked() || toAccount.isBlocked()) {
                        return;
                    }
                    if (fromAccount.getMoney() < amount) {
                        return;
                    }
                    try {
                        if (amount >= verificationLimit) {
                            if (isFraud(fromAccount.getAccNumber(), toAccount.getAccNumber(), amount)) {
                                fromAccount.blockedAccount();
                                System.out.println(fromAccount + " Счет заблокирован.");
                                return;
                            }
                            fromAccount.setMoney(fromAccount.getMoney() - amount);
                            toAccount.setMoney(toAccount.getMoney() + amount);
                        }
                        fromAccount.setMoney(fromAccount.getMoney() - amount);
                        toAccount.setMoney(toAccount.getMoney() + amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void addAccountToBank(Account account) {
        accounts.put(account.getAccNumber(),account);
    }

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sumBank = 0;
        for(ConcurrentMap.Entry<String, Account> accountEntry : accounts.entrySet()) {
            sumBank += accountEntry.getValue().getMoney();
        }
        return sumBank;
    }
}
