package map;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', department='%s'}", name, department);
    }
}

public class GroupByProperty {

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            String dept = employee.getDepartment();
            departmentMap.putIfAbsent(dept, new ArrayList<>());
            departmentMap.get(dept).add(employee);
        }

        return departmentMap;
    }

    public static Map<String, List<Employee>> groupByDepartmentStream(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "IT"),
                new Employee("Eve", "Finance"));

        Map<String, List<Employee>> grouped = groupByDepartment(employees);

        System.out.println("Employees grouped by department:");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
