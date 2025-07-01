class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Manager extends Employee {
    private int teamSize;
    private String department;

    public Manager(String name, int id, double salary, int teamSize, String department) {
        super(name, id, salary);
        this.teamSize = teamSize;
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== MANAGER DETAILS ===");
        super.displayDetails();
        System.out.println("Department: " + department);
        System.out.println("Team Size: " + teamSize + " members");
        System.out.println("Role: Manager");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.15 + (teamSize * 500);
    }

    public void conductMeeting() {
        System.out.println(name + " is conducting a team meeting with " + teamSize + " team members.");
    }

    public int getTeamSize() {
        return teamSize;
    }

    public String getDepartment() {
        return department;
    }
}

class Developer extends Employee {
    private String programmingLanguage;
    private String projectName;
    private int experienceYears;

    public Developer(String name, int id, double salary, String programmingLanguage,
            String projectName, int experienceYears) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
        this.projectName = projectName;
        this.experienceYears = experienceYears;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== DEVELOPER DETAILS ===");
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Current Project: " + projectName);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Role: Developer");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10 + (experienceYears * 1000);
    }

    public void writeCode() {
        System.out.println(name + " is writing code in " + programmingLanguage + " for project: " + projectName);
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}

class Intern extends Employee {
    private String university;
    private String mentor;
    private int internshipDuration;

    public Intern(String name, int id, double salary, String university,
            String mentor, int internshipDuration) {
        super(name, id, salary);
        this.university = university;
        this.mentor = mentor;
        this.internshipDuration = internshipDuration;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== INTERN DETAILS ===");
        super.displayDetails();
        System.out.println("University: " + university);
        System.out.println("Mentor: " + mentor);
        System.out.println("Internship Duration: " + internshipDuration + " months");
        System.out.println("Role: Intern");
    }

    @Override
    public double calculateBonus() {
        return 1000.0;
    }

    public void attendTraining() {
        System.out.println(name + " is attending training sessions under mentor: " + mentor);
    }

    public String getUniversity() {
        return university;
    }

    public String getMentor() {
        return mentor;
    }

    public int getInternshipDuration() {
        return internshipDuration;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===\n");

        Manager manager = new Manager("Alice Johnson", 101, 95000, 8, "Software Development");
        Developer developer = new Developer("Bob Smith", 102, 75000, "Java", "E-Commerce Platform", 5);
        Intern intern = new Intern("Charlie Brown", 103, 25000, "MIT", "Alice Johnson", 6);

        Employee[] employees = { manager, developer, intern };

        System.out.println("1. Employee Details:");
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Annual Bonus: $" + emp.calculateBonus());
            System.out.println();
        }

        System.out.println("2. Unique Employee Behaviors:");
        manager.conductMeeting();
        developer.writeCode();
        intern.attendTraining();

        System.out.println("\n3. Salary and Bonus Summary:");
        double totalSalaries = 0;
        double totalBonuses = 0;

        for (Employee emp : employees) {
            totalSalaries += emp.getSalary();
            totalBonuses += emp.calculateBonus();
            System.out.printf("%s - Salary: $%.2f, Bonus: $%.2f%n",
                    emp.getName(), emp.getSalary(), emp.calculateBonus());
        }

        System.out.printf("%nTotal Company Salaries: $%.2f%n", totalSalaries);
        System.out.printf("Total Company Bonuses: $%.2f%n", totalBonuses);
        System.out.printf("Total Company Cost: $%.2f%n", totalSalaries + totalBonuses);

        System.out.println("\n=== End of Employee Management Demo ===");
    }
}
