import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSalaryCategorization {
    static class Employee {
        String name;
        String department;
        double salary;

        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 60000),
                new Employee("Charlie", "HR", 55000),
                new Employee("David", "IT", 65000),
                new Employee("Eva", "Finance", 70000));
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByDept);
    }
}
