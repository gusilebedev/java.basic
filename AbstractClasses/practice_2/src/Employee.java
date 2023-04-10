public interface Employee extends Comparable<Employee> {
        int getMonthSalary();
        int getProfit();

        @Override
        int compareTo(Employee o);
}
