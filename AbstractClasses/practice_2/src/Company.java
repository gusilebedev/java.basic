import java.util.*;

public class Company {

    private ArrayList<Employee> employees;
    protected int income;
    protected Company() {
        employees = new ArrayList<>();
        initEmployees();
    }

    private void initEmployees() {
        for (int i = 0; i < 180; i++) {
            Operator operator = new Operator(50000);
            hire(operator);
        }
        for (int i = 0; i < 80; i++) {
            Manager manager = new Manager(80000);
            hire(manager);
        }
        for (Employee employee : employees) {
            income += employee.getProfit();
        }
        for (int i = 0; i < 10; i++) {
            TopManager topManager = new TopManager(150000, income);
            hire(topManager);
        }
    }

    private void hire(Employee employee) {
        this.employees.add(employee);
    }

    protected void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    protected void fire(Employee employee) {
        this.employees.remove(employee);
    }
    protected List<Employee> getTopSalaryStaff(int count) {
        Set<Employee> salary = new TreeSet<>(employees);
        List<Employee> salaryList = new ArrayList<>(salary);
        Collections.sort(salaryList);
        Collections.reverse(salaryList);
        return salaryList.subList(0,count);
    }

    protected List<Employee> getLowestSalaryStaff(int count) {
        Set<Employee> salary = new TreeSet<>(employees);
        List<Employee> salaryList = new ArrayList<>(salary);
        Collections.sort(salaryList);
        return salaryList.subList(0,count);
    }

    protected int getIncome() {
        return income;
    }
    protected int countEmployees() {
        return employees.size();
    }
    protected List<Employee> getEmployees() {
        return employees;
    }
}
