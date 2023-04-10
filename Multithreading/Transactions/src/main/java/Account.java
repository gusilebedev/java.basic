import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {
    private long money;
    private String accNumber;

    private boolean isBlocked;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
        this.isBlocked = false;
    }
    public void blockedAccount() {
        isBlocked = true;
    }
    @Override
    public String toString() {
        return getAccNumber() + ". Баланс: " + getMoney() + " руб.";
    }
}
