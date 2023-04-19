package practice;

public class CardAccount extends BankAccount {
    @Override
    public void take(double amountToTake) {
        if (amountToTake + (amountToTake/100) <= bankАccount) {
            bankАccount = bankАccount - amountToTake - (amountToTake/100);
        } else {
        }
    }
}

