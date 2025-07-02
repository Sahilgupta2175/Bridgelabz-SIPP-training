abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private double totalSalary;

    abstract double calculateSalary(double currentSalary);

    abstract void displayDetails(int employeeId, String name, double baseSalary, double totalSalary);

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setTotalSalary(double currentSalary) {
        this.totalSalary = calculateSalary(currentSalary);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getbaseSalary() {
        return baseSalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}

interface Department {
    public void assignEmployee(String Department);

    public void getDepartmentDetails(String Department);
}

class FullTimeEmployee extends Employee implements Department {
    @Override
    double calculateSalary(double currentSalary) {
        return getbaseSalary() + currentSalary;
    }

    public void assignEmployee(String Department) {
        System.out.println(super.getName() + " is assigned to " + Department + " department.");
    }

    public void getDepartmentDetails(String Department) {
        System.out.println("Department details for " + super.getName() + ":");
        System.out.println("Employee Id: " + super.getEmployeeId());
        System.out.println("Employee Name: " + super.getName());
        System.out.println("Base Salary: " + super.getbaseSalary());
        System.out.println("Total Salary: " + super.getTotalSalary());
        System.out.println("Department: " + Department);
    }

    void displayDetails(int employeeId, String name, double baseSalary, double totalSalary) {
        System.out.println("Employee Id is : " + employeeId);
        System.out.println("Employee name is : " + name);
        System.out.println("Employee baseSalary is : " + baseSalary);
        System.out.println("Employee totalSalary is : " + totalSalary);
    }
}

class PartTimeEmployee extends Employee implements Department {
    @Override
    double calculateSalary(double currentSalary) {
        return getbaseSalary() + (currentSalary * 0.5);
    }

    public void assignEmployee(String Department) {
        System.out.println(super.getName() + " is assigned to " + Department + " department.");
    }

    public void getDepartmentDetails(String Department) {
        System.out.println("Department details for " + super.getName() + ":");
        System.out.println("Employee Id: " + super.getEmployeeId());
        System.out.println("Employee Name: " + super.getName());
        System.out.println("Base Salary: " + super.getbaseSalary());
        System.out.println("Total Salary: " + super.getTotalSalary());
        System.out.println("Department: " + Department);
    }

    void displayDetails(int employeeId, String name, double baseSalary, double totalSalary) {
        System.out.println("Employee Id is : " + employeeId);
        System.out.println("Employee name is : " + name);
        System.out.println("Employee baseSalary is : " + baseSalary);
        System.out.println("Employee totalSalary is : " + totalSalary);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.setEmployeeId(101);
        fullTimeEmployee.setName("Alice");
        fullTimeEmployee.setBaseSalary(50000);
        fullTimeEmployee.setTotalSalary(10000);
        fullTimeEmployee.displayDetails(fullTimeEmployee.getEmployeeId(), fullTimeEmployee.getName(),
                fullTimeEmployee.getbaseSalary(), fullTimeEmployee.getTotalSalary());
        fullTimeEmployee.assignEmployee("HR");
        fullTimeEmployee.getDepartmentDetails("HR");

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setEmployeeId(102);
        partTimeEmployee.setName("Bob");
        partTimeEmployee.setBaseSalary(30000);
        partTimeEmployee.setTotalSalary(5000);
        partTimeEmployee.displayDetails(partTimeEmployee.getEmployeeId(), partTimeEmployee.getName(),
                partTimeEmployee.getbaseSalary(), partTimeEmployee.getTotalSalary());
        partTimeEmployee.assignEmployee("Finance");
        partTimeEmployee.getDepartmentDetails("Finance");
    }
}