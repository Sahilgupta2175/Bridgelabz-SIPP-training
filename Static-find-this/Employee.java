/**
 * Employee class for Employee Management System
 * Demonstrates static variables, static methods, this keyword, final variables,
 * and instanceof
 */
public class Employee {
    // Static variable shared across all employees - represents the company name
    private static String companyName = "TechCorp Solutions";

    // Static variable to track total number of employees
    private static int totalEmployees = 0;

    // Instance variables
    private String name;
    private String designation;

    // Final variable - employee ID cannot be changed once assigned
    private final String id;

    private double salary;
    private String department;

    /**
     * Constructor to create a new employee
     * Uses 'this' keyword to initialize instance variables when parameter names
     * match
     * 
     * @param name        Name of the employee
     * @param id          Unique employee ID (final - cannot be changed)
     * @param designation Job designation of the employee
     * @param salary      Salary of the employee
     * @param department  Department where employee works
     */
    public Employee(String name, String id, String designation, double salary, String department) {
        // Using 'this' to distinguish between instance variables and parameters
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.department = department;

        // Final variable assignment - can only be done once during initialization
        this.id = id;

        // Increment static counter for total employees
        totalEmployees++;
    }

    /**
     * Static method to display the total number of employees
     * Can be called without creating an instance of the Employee class
     */
    public static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + ": " + totalEmployees);
    }

    /**
     * Static method to get the company name
     * 
     * @return Current company name
     */
    public static String getCompanyName() {
        return companyName;
    }

    /**
     * Static method to change the company name
     * 
     * @param newCompanyName New name for the company
     */
    public static void setCompanyName(String newCompanyName) {
        companyName = newCompanyName;
        System.out.println("Company name updated to: " + companyName);
    }

    /**
     * Static method to get total employees count
     * 
     * @return Total number of employees
     */
    public static int getTotalEmployees() {
        return totalEmployees;
    }

    /**
     * Method to give a salary raise to the employee
     * 
     * @param raiseAmount Amount to increase in salary
     */
    public void giveRaise(double raiseAmount) {
        if (raiseAmount > 0) {
            this.salary += raiseAmount;
            System.out.println("Salary raise of $" + raiseAmount + " given to " + this.name);
            System.out.println("New salary: $" + this.salary);
        } else {
            System.out.println("Invalid raise amount!");
        }
    }

    /**
     * Method to promote an employee
     * 
     * @param newDesignation New job designation
     * @param salaryIncrease Salary increase with promotion
     */
    public void promote(String newDesignation, double salaryIncrease) {
        String oldDesignation = this.designation;
        this.designation = newDesignation;
        this.salary += salaryIncrease;

        System.out.println("Employee " + this.name + " promoted!");
        System.out.println("From: " + oldDesignation + " To: " + this.designation);
        System.out.println("New salary: $" + this.salary);
    }

    /**
     * Method to display detailed employee information
     * This method is called only after instanceof verification
     */
    public void displayEmployeeDetails() {
        System.out.println("\n=== Employee Details ===");
        System.out.println("Company: " + companyName);
        System.out.println("Employee ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Designation: " + this.designation);
        System.out.println("Department: " + this.department);
        System.out.println("Salary: $" + this.salary);
        System.out.println("========================");
    }

    /**
     * Static method to safely display employee information using instanceof
     * Demonstrates type checking before casting and method invocation
     * 
     * @param obj Object to be verified and displayed
     */
    public static void displayEmployeeInfo(Object obj) {
        // Using instanceof to check if the object is of Employee type
        if (obj instanceof Employee) {
            System.out.println("Valid Employee object detected!");
            Employee employee = (Employee) obj; // Safe casting after instanceof check
            employee.displayEmployeeDetails();
        } else {
            System.out.println("Error: Object is not an instance of Employee class!");
            System.out.println("Cannot display employee information for: " + obj.getClass().getSimpleName());
        }
    }

    /**
     * Method to calculate annual salary
     * 
     * @return Annual salary of the employee
     */
    public double getAnnualSalary() {
        return this.salary * 12;
    }

    /**
     * Method to check if employee belongs to a specific department
     * 
     * @param dept Department name to check
     * @return true if employee belongs to the department, false otherwise
     */
    public boolean isInDepartment(String dept) {
        return this.department.equalsIgnoreCase(dept);
    }

    /**
     * Getter methods for accessing private fields
     */
    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id; // Final variable - read-only access
    }

    public String getDesignation() {
        return this.designation;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDepartment() {
        return this.department;
    }

    /**
     * Setter methods (excluding final variable 'id')
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Main method to demonstrate the Employee class functionality
     */
    public static void main(String[] args) {
        System.out.println("=== Employee Management System Demo ===\n");

        // Display initial company information
        System.out.println("Company: " + Employee.getCompanyName());
        Employee.displayTotalEmployees();

        // Create employee instances
        Employee emp1 = new Employee("Alice Johnson", "EMP001", "Software Developer", 75000, "IT");
        Employee emp2 = new Employee("Bob Smith", "EMP002", "Marketing Specialist", 60000, "Marketing");
        Employee emp3 = new Employee("Carol Williams", "EMP003", "HR Manager", 80000, "Human Resources");
        Employee emp4 = new Employee("David Brown", "EMP004", "Financial Analyst", 70000, "Finance");

        // Display updated employee count
        System.out.println("\nAfter hiring employees:");
        Employee.displayTotalEmployees();

        // Demonstrate employee operations
        System.out.println("\n=== Employee Operations ===");
        emp1.giveRaise(5000);
        emp2.promote("Senior Marketing Specialist", 8000);
        emp3.giveRaise(3000);

        // Demonstrate instanceof usage with valid Employee objects
        System.out.println("\n=== Instanceof Demonstration ===");
        Employee.displayEmployeeInfo(emp1);
        Employee.displayEmployeeInfo(emp2);
        Employee.displayEmployeeInfo(emp3);
        Employee.displayEmployeeInfo(emp4);

        // Demonstrate instanceof with invalid objects
        String invalidObject1 = "Not an Employee";
        Double invalidObject2 = 123.45;
        Employee.displayEmployeeInfo(invalidObject1);
        Employee.displayEmployeeInfo(invalidObject2);

        // Demonstrate company name change
        System.out.println("\n=== Company Name Change Demo ===");
        Employee.setCompanyName("InnovateTech Corp");
        Employee.displayTotalEmployees();

        // Display an employee to show updated company name
        Employee.displayEmployeeInfo(emp1);

        // Final variable demonstration
        System.out.println("\n=== Final Variable Demo ===");
        System.out.println("Employee ID (final variable): " + emp1.getId());
        // emp1.id = "NEW_EMP001"; // Uncommenting this would cause compilation error

        // Department-wise employee filtering
        System.out.println("\n=== Department-wise Employee Listing ===");
        Employee[] allEmployees = { emp1, emp2, emp3, emp4 };
        String targetDepartment = "IT";

        System.out.println("Employees in " + targetDepartment + " department:");
        for (Employee emp : allEmployees) {
            if (emp.isInDepartment(targetDepartment)) {
                System.out.println("- " + emp.getName() + " (" + emp.getDesignation() + ")");
            }
        }

        // Annual salary calculation
        System.out.println("\n=== Annual Salary Report ===");
        for (Employee emp : allEmployees) {
            System.out.println(emp.getName() + " - Annual Salary: $" + emp.getAnnualSalary());
        }

        // Final statistics
        System.out.println("\n=== Final Company Statistics ===");
        System.out.println("Company: " + Employee.getCompanyName());
        Employee.displayTotalEmployees();

        // Calculate total company salary expense
        double totalSalaryExpense = 0;
        for (Employee emp : allEmployees) {
            totalSalaryExpense += emp.getSalary();
        }
        System.out.println("Monthly Salary Expense: $" + totalSalaryExpense);
        System.out.println("Annual Salary Expense: $" + (totalSalaryExpense * 12));
    }
}
