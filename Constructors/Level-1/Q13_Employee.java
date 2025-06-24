public class Q13_Employee {
    public String employeeID;
    protected String department;
    private double salary;

    public Q13_Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Error: Salary must be positive.");
        }
    }

    public void giveRaise(double percentage) {
        if (percentage > 0) {
            double raiseAmount = salary * percentage / 100;
            salary += raiseAmount;
            System.out.println("Raise of " + percentage + "% ($" + raiseAmount + ") given.");
        } else {
            System.out.println("Error: Percentage must be positive.");
        }
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Q13_Manager extends Q13_Employee {
    private int teamSize;
    private double bonus;

    public Q13_Manager(String employeeID, String department, double salary, int teamSize, double bonus) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
        this.bonus = bonus;
    }

    public double calculateTotalCompensation() {
        return getSalary() + bonus;
    }

    public void demonstrateAccess() {
        System.out.println("Accessing Public Member (Employee ID): " + employeeID);
        System.out.println("Accessing Protected Member (Department): " + department);
        System.out.println("Accessing Private Member via getter: $" + getSalary());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize + " employees");
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Compensation: $" + calculateTotalCompensation());
    }

    public static void main(String[] args) {
        Q13_Employee employee = new Q13_Employee("E001", "IT", 50000.0);
        System.out.println("Regular Employee:");
        employee.displayDetails();

        System.out.println("\nGiving a Raise:");
        employee.giveRaise(5.0);
        employee.displayDetails();

        System.out.println("\nManager:");
        Q13_Manager manager = new Q13_Manager("M001", "Marketing", 80000.0, 5, 10000.0);
        manager.displayDetails();

        System.out.println("\nDemonstrating Access to Members in Manager:");
        manager.demonstrateAccess();

        System.out.println("\nModifying Manager's Salary:");
        manager.setSalary(85000.0);
        manager.displayDetails();
    }
}
