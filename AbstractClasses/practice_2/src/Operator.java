public class Operator implements Employee {

    private final int salary;

    public Operator(int salary) {
        this.salary = salary;
    }
    @Override
    public int getMonthSalary(){
        return salary;
    }
    @Override
    public int getProfit() {
        return 0;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(getMonthSalary(),o.getMonthSalary());
    }
}
