import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        initWorkBank();
    }

    public static void initWorkBank() throws InterruptedException {

        Bank bank = new Bank();

        Account account1 = new Account("Клиент №1", (long) (5000000 * Math.random()));
        Account account2 = new Account("Клиент №2", (long) (5000000 * Math.random()));
        Account account3 = new Account("Клиент №3", (long) (5000000 * Math.random()));
        Account account4 = new Account("Клиент №4", (long) (5000000 * Math.random()));

        bank.addAccountToBank(account1);
        bank.addAccountToBank(account2);
        bank.addAccountToBank(account3);
        bank.addAccountToBank(account4);

        ArrayList<Thread> threads = new ArrayList<>();

        threads.add(new Thread(new Transactions(bank, account1, account2, (long) (Math.random() * 50005))));
        threads.add(new Thread(new Transactions(bank, account2, account3, (long) (Math.random() * 50005))));
        threads.add(new Thread(new Transactions(bank, account3, account4, (long) (Math.random() * 50005))));
        threads.add(new Thread(new Transactions(bank, account4, account1, (long) (Math.random() * 50005))));

        System.out.println(bank.getSumAllAccounts());

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
            System.out.println(bank.getSumAllAccounts());
        }
    }
}

