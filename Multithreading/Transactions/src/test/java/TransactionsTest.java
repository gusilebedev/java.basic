import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;

public class TransactionsTest extends TestCase {
    Bank bank;
    ArrayList<Thread> threads;
    Account account1;
    Account account2;
    Account account3;
    Account account4;
    @Override
    protected void setUp() {
        bank = new Bank();
        bank.addAccountToBank(account1 = new Account("Клиент №1",(long) (5000000 * Math.random())));
        bank.addAccountToBank(account2 = new Account("Клиент №2",(long) (5000000 * Math.random())));
        bank.addAccountToBank(account3 = new Account("Клиент №3",(long) (5000000 * Math.random())));
        bank.addAccountToBank(account4 = new Account("Клиент №4",(long) (5000000 * Math.random())));
    }
    @Test
    public void testSumBank() {
        long actual = bank.getSumAllAccounts();
        long expected = account1.getMoney() + account2.getMoney() + account3.getMoney() + account4.getMoney();
        assertEquals(expected,actual);
    }
    @Test
    public void testSumBankAfterVerificationLimit() throws InterruptedException {
        threads = new ArrayList<>();
        threads.add(new Thread(new Transactions(bank, account1, account2, (long) (Math.random() * 70000))));
        threads.add(new Thread(new Transactions(bank, account2, account3, (long) (Math.random() * 70000))));
        threads.add(new Thread(new Transactions(bank, account3, account4, (long) (Math.random() * 70000))));
        threads.add(new Thread(new Transactions(bank, account4, account1, (long) (Math.random() * 70000))));
        long actual = bank.getSumAllAccounts();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long expected = bank.getSumAllAccounts();
        assertEquals(expected,actual);
    }

    @Test
    public void testSumBankBeforeVerificationLimit() throws InterruptedException {
        threads = new ArrayList<>();
        threads.add(new Thread(new Transactions(bank, account1, account2, (long) (Math.random() * 49995))));
        threads.add(new Thread(new Transactions(bank, account2, account3, (long) (Math.random() * 49995))));
        threads.add(new Thread(new Transactions(bank, account3, account4, (long) (Math.random() * 49995))));
        threads.add(new Thread(new Transactions(bank, account4, account1, (long) (Math.random() * 49995))));
        long actual = bank.getSumAllAccounts();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long expected = bank.getSumAllAccounts();
        assertEquals(expected,actual);
    }
}
