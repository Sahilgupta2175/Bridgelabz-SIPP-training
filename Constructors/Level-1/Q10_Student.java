public class Q10_Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Q10_Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value. Must be between 0.0 and 10.0.");
        }
    }

    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

class Q10_PostgraduateStudent extends Q10_Student {
    private String specializationArea;
    private String researchTopic;

    public Q10_PostgraduateStudent(int rollNumber, String name, double CGPA,
            String specializationArea, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.specializationArea = specializationArea;
        this.researchTopic = researchTopic;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization Area: " + specializationArea);
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("Name (accessing protected member): " + name);
    }

    public static void main(String[] args) {
        Q10_Student student = new Q10_Student(101, "John Smith", 8.5);
        System.out.println("Regular Student:");
        student.displayDetails();

        System.out.println("\nModifying CGPA:");
        System.out.println("Current CGPA: " + student.getCGPA());
        student.setCGPA(9.0);
        System.out.println("Updated CGPA: " + student.getCGPA());

        student.setCGPA(11.0);

        System.out.println("\nPostgraduate Student:");
        Q10_PostgraduateStudent pgStudent = new Q10_PostgraduateStudent(201, "Jane Doe",
                9.2, "Computer Science",
                "Machine Learning Applications");
        pgStudent.displayDetails();

        System.out.println("\nDemonstrating Access to Members:");
        System.out.println("Public Member (Roll Number): " + pgStudent.rollNumber);
        System.out.println("Protected Member (Name): " + pgStudent.name);
    }
}
