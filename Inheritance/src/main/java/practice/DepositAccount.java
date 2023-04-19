package practice;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends BankAccount {

    private Calendar lastIncome;

    @Override
    public void take(double amountToTake) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MONTH,-1);
        if (amountToTake <= bankАccount && date.after(lastIncome)) {
            bankАccount = bankАccount - amountToTake;
        } else {
        }
    }
    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0) {
            lastIncome = Calendar.getInstance();
            bankАccount = bankАccount + amountToPut;
        } else {
        }
    }
}

