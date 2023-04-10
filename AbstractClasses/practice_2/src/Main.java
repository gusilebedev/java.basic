public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        printHighestSalaries(company,15);
        printLowestSalaries(company,30);
        fireHalfEmployees(company);
        printHighestSalaries(company,15);
        printLowestSalaries(company,30);
    }


    private static void printLowestSalaries(Company String, int count) {
        if (count > 0 && count < String.countEmployees()) {
            System.out.println("Самые низкие зарплаты: ");
            for (Employee employee : String.getLowestSalaryStaff(count)) {
                System.out.println(employee.getMonthSalary());
            }
        } else {
        }
    }

    private static void printHighestSalaries(Company String, int count) {
        if(count > 0 && count < String.countEmployees()) {
            System.out.println("Самые высокие зарплаты: ");
            for (Employee employee : String.getTopSalaryStaff(count)) {
                System.out.println(employee.getMonthSalary());
            }
        }
    }

    private static void fireHalfEmployees(Company String) {
        int index = String.countEmployees() - 1;
        while (index >= 0) {
            if(index % 2 == 0) {
                String.fire(String.getEmployees().get(index));
            }
            index -= 1;
        }
        System.out.println("Уволено 50 % сотрудников");
    }
}


