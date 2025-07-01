class Person {
    protected String name;
    protected int age;
    protected String id;
    protected String address;

    public Person(String name, int age, String id, String address) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + id);
        System.out.println("Address: " + address);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}

class Teacher extends Person {
    private String subject;
    private int experienceYears;
    private double salary;

    public Teacher(String name, int age, String id, String address, String subject, 
                  int experienceYears, double salary) {
        super(name, age, id, address);
        this.subject = subject;
        this.experienceYears = experienceYears;
        this.salary = salary;
    }

    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Salary: $" + salary);
    }

    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();
        displayRole();
    }

    public void teachClass() {
        System.out.println(name + " is teaching " + subject);
    }

    public void gradeStudents() {
        System.out.println(name + " is grading " + subject + " assignments");
    }

    public String getSubject() {
        return subject;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public double getSalary() {
        return salary;
    }
}

class Student extends Person {
    private String grade;
    private double gpa;
    private String major;

    public Student(String name, int age, String id, String address, String grade, double gpa, String major) {
        super(name, age, id, address);
        this.grade = grade;
        this.gpa = gpa;
        this.major = major;
    }

    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
    }

    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();
        displayRole();
    }

    public void attendClass() {
        System.out.println(name + " is attending class");
    }

    public void submitAssignment() {
        System.out.println(name + " has submitted an assignment for " + major);
    }

    public String getGrade() {
        return grade;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }
}

class Staff extends Person {
    private String department;
    private String position;
    private String workShift;

    public Staff(String name, int age, String id, String address, String department, 
                String position, String workShift) {
        super(name, age, id, address);
        this.department = department;
        this.position = position;
        this.workShift = workShift;
    }

    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Work Shift: " + workShift);
    }

    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();
        displayRole();
    }

    public void performDuties() {
        System.out.println(name + " is performing " + position + " duties in " + department);
    }

    public void manageResources() {
        System.out.println(name + " is managing resources for " + department);
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getWorkShift() {
        return workShift;
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        System.out.println("=== School System ===\n");

        Teacher teacher = new Teacher("Dr. Smith", 45, "T001", "123 Main St", "Mathematics", 15, 65000);
        Student student = new Student("Alice Johnson", 19, "S001", "456 Oak Ave", "Sophomore", 3.8, "Computer Science");
        Staff staff = new Staff("Bob Wilson", 35, "ST001", "789 Pine Rd", "Administration", "Office Manager", "Day");

        System.out.println("1. Teacher Information:");
        teacher.displayPersonInfo();
        teacher.teachClass();
        teacher.gradeStudents();
        System.out.println();

        System.out.println("2. Student Information:");
        student.displayPersonInfo();
        student.attendClass();
        student.submitAssignment();
        System.out.println();

        System.out.println("3. Staff Information:");
        staff.displayPersonInfo();
        staff.performDuties();
        staff.manageResources();
        System.out.println();

        System.out.println("4. School Directory:");
        Person[] people = {teacher, student, staff};
        for (Person person : people) {
            System.out.println(person.getName() + " - ID: " + person.getId());
        }

        System.out.println("\n=== End of School System Demo ===");
    }
}
