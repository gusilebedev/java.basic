public class TopManager implements Employee {

    private final int salary;
    private final int income;

    public TopManager(int salary, int income) {
        this.salary = salary + bonus();
        this.income = income;
    }
    @Override
    public int getMonthSalary(){
        return salary + bonus();
    }
    @Override
    public int getProfit() {
        return 0;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(getMonthSalary(),o.getMonthSalary());
    }

    public int bonus(){
        int bonus;
        if (income > 10000000) {
            bonus = (int)(salary * 1.5);
        } else {
            bonus = 0;
        }
        return bonus;
    }
}