public class Manager implements Employee {

    private final int salary;

    public Manager(int salary) {
        this.salary = salary + (int)(getProfit() * 0.05);
    }
    @Override
    public int getMonthSalary(){
        return salary;
    }

    @Override
    public int getProfit() {
        int profit = (int) Math.round(25000 * Math.random() + 115000);
        return profit;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(getMonthSalary(),o.getMonthSalary());
    }
}