package practice;

public class BankAccount {
protected double bankАccount;

  public double getAmount() {
    return bankАccount;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0) {
      bankАccount = bankАccount + amountToPut;
    } else {
    }
  }

  public void take(double amountToTake) {
    if (amountToTake <= bankАccount) {
      bankАccount = bankАccount - amountToTake;
    } else {
    }
  }
}
