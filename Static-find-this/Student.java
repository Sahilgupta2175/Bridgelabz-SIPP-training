/**
 * Student class for University Student Management System
 * Demonstrates static variables, static methods, this keyword, final variables,
 * and instanceof
 */
public class Student {
    // Static variable shared across all students - represents the university name
    private static String universityName = "State University";

    // Static variable to track total number of students enrolled
    private static int totalStudents = 0;

    // Instance variables
    private String name;
    private String grade;

    // Final variable - roll number cannot be changed once assigned
    private final String rollNumber;

    private String course;
    private double gpa;
    private int semester;

    /**
     * Constructor to create a new student
     * Uses 'this' keyword to initialize instance variables when parameter names
     * match
     * 
     * @param name       Name of the student
     * @param rollNumber Unique roll number for the student (final - cannot be
     *                   changed)
     * @param grade      Current grade/year of the student
     * @param course     Course/major the student is enrolled in
     * @param gpa        Grade Point Average of the student
     * @param semester   Current semester of the student
     */
    public Student(String name, String rollNumber, String grade, String course, double gpa, int semester) {
        // Using 'this' to distinguish between instance variables and parameters
        this.name = name;
        this.grade = grade;
        this.course = course;
        this.gpa = gpa;
        this.semester = semester;

        // Final variable assignment - can only be done once during initialization
        this.rollNumber = rollNumber;

        // Increment static counter for total students
        totalStudents++;
    }

    /**
     * Static method to display the total number of students enrolled
     * Can be called without creating an instance of the Student class
     */
    public static void displayTotalStudents() {
        System.out.println("Total students enrolled in " + universityName + ": " + totalStudents);
    }

    /**
     * Static method to get the university name
     * 
     * @return Current university name
     */
    public static String getUniversityName() {
        return universityName;
    }

    /**
     * Static method to change the university name
     * 
     * @param newUniversityName New name for the university
     */
    public static void setUniversityName(String newUniversityName) {
        universityName = newUniversityName;
        System.out.println("University name updated to: " + universityName);
    }

    /**
     * Static method to get total students count
     * 
     * @return Total number of students enrolled
     */
    public static int getTotalStudents() {
        return totalStudents;
    }

    /**
     * Static method to display university information
     */
    public static void displayUniversityInfo() {
        System.out.println("University: " + universityName);
        System.out.println("Total Enrolled Students: " + totalStudents);
    }

    /**
     * Method to update student's GPA
     * 
     * @param newGpa New GPA value to be set
     */
    public void updateGPA(double newGpa) {
        if (newGpa >= 0.0 && newGpa <= 4.0) {
            double oldGpa = this.gpa;
            this.gpa = newGpa;
            System.out.println("GPA updated for " + this.name);
            System.out.println("Previous GPA: " + oldGpa + " | New GPA: " + this.gpa);
            updateGradeBasedOnGPA();
        } else {
            System.out.println("Invalid GPA! Must be between 0.0 and 4.0");
        }
    }

    /**
     * Method to advance student to next semester
     */
    public void advanceToNextSemester() {
        if (this.gpa >= 2.0) { // Minimum GPA requirement to advance
            this.semester++;
            System.out.println(this.name + " advanced to semester " + this.semester);

            // Update grade based on semester
            if (this.semester <= 2) {
                this.grade = "Freshman";
            } else if (this.semester <= 4) {
                this.grade = "Sophomore";
            } else if (this.semester <= 6) {
                this.grade = "Junior";
            } else {
                this.grade = "Senior";
            }
        } else {
            System.out.println(this.name + " cannot advance due to low GPA: " + this.gpa);
        }
    }

    /**
     * Private helper method to update grade based on GPA
     */
    private void updateGradeBasedOnGPA() {
        if (this.gpa >= 3.7) {
            System.out.println("Academic standing: Excellent (Dean's List)");
        } else if (this.gpa >= 3.0) {
            System.out.println("Academic standing: Good");
        } else if (this.gpa >= 2.0) {
            System.out.println("Academic standing: Satisfactory");
        } else {
            System.out.println("Academic standing: Probation - Needs improvement");
        }
    }

    /**
     * Method to calculate total credits based on semester
     * 
     * @return Estimated total credits completed
     */
    public int calculateTotalCredits() {
        return this.semester * 15; // Assuming 15 credits per semester
    }

    /**
     * Method to check if student is eligible for graduation
     * 
     * @return true if eligible for graduation, false otherwise
     */
    public boolean isEligibleForGraduation() {
        return this.semester >= 8 && this.gpa >= 2.0;
    }

    /**
     * Method to display detailed student information
     * This method is called only after instanceof verification
     */
    public void displayStudentDetails() {
        System.out.println("\n=== Student Details ===");
        System.out.println("University: " + universityName);
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Name: " + this.name);
        System.out.println("Grade: " + this.grade);
        System.out.println("Course/Major: " + this.course);
        System.out.println("Current Semester: " + this.semester);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Total Credits: " + calculateTotalCredits());
        System.out.println("Graduation Eligible: " + (isEligibleForGraduation() ? "Yes" : "No"));
        System.out.println("=======================");
    }

    /**
     * Static method to safely display student information using instanceof
     * Demonstrates type checking before casting and method invocation
     * 
     * @param obj Object to be verified and displayed
     */
    public static void displayStudentInfo(Object obj) {
        // Using instanceof to check if a given object is an instance of the Student
        // class
        if (obj instanceof Student) {
            System.out.println("Valid Student object detected!");
            Student student = (Student) obj; // Safe casting after instanceof check
            student.displayStudentDetails();
        } else {
            System.out.println("Error: Object is not an instance of Student class!");
            System.out.println("Cannot perform operations on: " + obj.getClass().getSimpleName());
        }
    }

    /**
     * Static method to safely update grades using instanceof
     * 
     * @param obj    Object to be verified before updating grades
     * @param newGpa New GPA to be set
     */
    public static void updateStudentGrade(Object obj, double newGpa) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            student.updateGPA(newGpa);
        } else {
            System.out.println("Cannot update grades: Object is not a Student instance!");
        }
    }

    /**
     * Method to compare GPA with another student
     * 
     * @param otherStudent Student to compare with
     * @return Comparison result
     */
    public String compareGPA(Student otherStudent) {
        if (this.gpa > otherStudent.gpa) {
            return this.name + " has higher GPA than " + otherStudent.name;
        } else if (this.gpa < otherStudent.gpa) {
            return otherStudent.name + " has higher GPA than " + this.name;
        } else {
            return this.name + " and " + otherStudent.name + " have the same GPA";
        }
    }

    /**
     * Getter methods for accessing private fields
     */
    public String getName() {
        return this.name;
    }

    public String getRollNumber() {
        return this.rollNumber; // Final variable - read-only access
    }

    public String getGrade() {
        return this.grade;
    }

    public String getCourse() {
        return this.course;
    }

    public double getGpa() {
        return this.gpa;
    }

    public int getSemester() {
        return this.semester;
    }

    /**
     * Setter methods (excluding final variable 'rollNumber')
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Main method to demonstrate the Student class functionality
     */
    public static void main(String[] args) {
        System.out.println("=== University Student Management System Demo ===\n");

        // Display initial university information
        Student.displayUniversityInfo();

        // Create student instances
        Student student1 = new Student("Alice Johnson", "CS2021001", "Sophomore", "Computer Science", 3.8, 3);
        Student student2 = new Student("Bob Smith", "EE2021002", "Junior", "Electrical Engineering", 3.2, 5);
        Student student3 = new Student("Carol Williams", "BA2021003", "Freshman", "Business Administration", 2.9, 1);
        Student student4 = new Student("David Brown", "ME2021004", "Senior", "Mechanical Engineering", 3.5, 7);
        Student student5 = new Student("Eva Davis", "BIO2021005", "Sophomore", "Biology", 3.9, 4);

        // Display updated student count
        System.out.println("\nAfter student enrollment:");
        Student.displayTotalStudents();

        // Demonstrate student operations
        System.out.println("\n=== Student Operations ===");

        // Update GPAs
        student1.updateGPA(3.9);
        student2.updateGPA(3.4);
        student3.updateGPA(1.8); // Below passing grade

        // Advance students to next semester
        System.out.println("\n--- Semester Advancement ---");
        student1.advanceToNextSemester();
        student2.advanceToNextSemester();
        student3.advanceToNextSemester(); // Should fail due to low GPA
        student4.advanceToNextSemester();

        // Demonstrate instanceof usage with valid Student objects
        System.out.println("\n=== Instanceof Demonstration ===");
        Student.displayStudentInfo(student1);
        Student.displayStudentInfo(student2);
        Student.displayStudentInfo(student3);
        Student.displayStudentInfo(student4);
        Student.displayStudentInfo(student5);

        // Demonstrate instanceof with invalid objects
        String invalidObject1 = "Not a Student";
        Double invalidObject2 = 3.5;
        Student.displayStudentInfo(invalidObject1);
        Student.displayStudentInfo(invalidObject2);

        // Demonstrate instanceof in grade update method
        System.out.println("\n=== Instanceof in Grade Update ===");
        Student.updateStudentGrade(student3, 2.5); // Valid student object
        Student.updateStudentGrade("Invalid Object", 3.0); // Invalid object

        // Demonstrate university name change
        System.out.println("\n=== University Name Change Demo ===");
        Student.setUniversityName("Tech University");
        Student.displayUniversityInfo();

        // Display a student to show updated university name
        Student.displayStudentInfo(student1);

        // Final variable demonstration
        System.out.println("\n=== Final Variable Demo ===");
        System.out.println("Student Roll Number (final variable): " + student1.getRollNumber());
        // student1.rollNumber = "NEW_CS2021001"; // Uncommenting this would cause
        // compilation error

        // Student comparison demonstration
        System.out.println("\n=== Student GPA Comparison ===");
        Student[] allStudents = { student1, student2, student3, student4, student5 };

        for (int i = 0; i < allStudents.length - 1; i++) {
            System.out.println(allStudents[i].compareGPA(allStudents[i + 1]));
        }

        // Graduation eligibility check
        System.out.println("\n=== Graduation Eligibility Report ===");
        for (Student student : allStudents) {
            String eligibility = student.isEligibleForGraduation() ? "Eligible" : "Not Eligible";
            System.out.println(student.getName() + " (" + student.getRollNumber() + "): " + eligibility);
        }

        // Course-wise student distribution
        System.out.println("\n=== Course-wise Student Distribution ===");
        String[] courses = { "Computer Science", "Electrical Engineering", "Business Administration",
                "Mechanical Engineering", "Biology" };

        for (String course : courses) {
            System.out.print(course + ": ");
            for (Student student : allStudents) {
                if (student.getCourse().equals(course)) {
                    System.out.print(student.getName() + " ");
                }
            }
            System.out.println();
        }

        // Final statistics
        System.out.println("\n=== Final University Statistics ===");
        System.out.println("University: " + Student.getUniversityName());
        Student.displayTotalStudents();

        // Calculate average GPA
        double totalGPA = 0;
        for (Student student : allStudents) {
            totalGPA += student.getGpa();
        }
        double averageGPA = totalGPA / allStudents.length;
        System.out.println("Average GPA: " + String.format("%.2f", averageGPA));

        // Find student with highest GPA
        Student topStudent = allStudents[0];
        for (Student student : allStudents) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        System.out.println("Top Student: " + topStudent.getName() + " (GPA: " + topStudent.getGpa() + ")");
    }
}
