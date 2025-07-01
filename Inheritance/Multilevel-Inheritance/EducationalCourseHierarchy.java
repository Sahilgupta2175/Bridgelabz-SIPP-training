class Course {
    protected String courseName;
    protected int duration;
    protected String instructor;
    protected String difficulty;

    public Course(String courseName, int duration, String instructor, String difficulty) {
        this.courseName = courseName;
        this.duration = duration;
        this.instructor = instructor;
        this.difficulty = difficulty;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Instructor: " + instructor);
        System.out.println("Difficulty: " + difficulty);
    }

    public void startCourse() {
        System.out.println("Starting course: " + courseName);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDifficulty() {
        return difficulty;
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    protected String accessLink;
    protected int maxStudents;

    public OnlineCourse(String courseName, int duration, String instructor, String difficulty,
            String platform, boolean isRecorded, String accessLink, int maxStudents) {
        super(courseName, duration, instructor, difficulty);
        this.platform = platform;
        this.isRecorded = isRecorded;
        this.accessLink = accessLink;
        this.maxStudents = maxStudents;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
        System.out.println("Access Link: " + accessLink);
        System.out.println("Max Students: " + maxStudents);
    }

    @Override
    public void startCourse() {
        System.out.println("Joining online course: " + courseName + " on " + platform);
    }

    public void joinLiveSession() {
        if (!isRecorded) {
            System.out.println("Joining live session for: " + courseName);
        } else {
            System.out.println("This is a recorded course. Access anytime!");
        }
    }

    public String getPlatform() {
        return platform;
    }

    public boolean isRecorded() {
        return isRecorded;
    }

    public String getAccessLink() {
        return accessLink;
    }

    public int getMaxStudents() {
        return maxStudents;
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;
    private String paymentMethod;
    private boolean certificateIncluded;

    public PaidOnlineCourse(String courseName, int duration, String instructor, String difficulty,
            String platform, boolean isRecorded, String accessLink, int maxStudents,
            double fee, double discount, String paymentMethod, boolean certificateIncluded) {
        super(courseName, duration, instructor, difficulty, platform, isRecorded, accessLink, maxStudents);
        this.fee = fee;
        this.discount = discount;
        this.paymentMethod = paymentMethod;
        this.certificateIncluded = certificateIncluded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Course Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + calculateFinalPrice());
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Certificate: " + (certificateIncluded ? "Included" : "Not Included"));
    }

    @Override
    public void startCourse() {
        System.out.println("Starting paid course: " + courseName + " - Payment confirmed via " + paymentMethod);
    }

    public double calculateFinalPrice() {
        return fee - (fee * discount / 100);
    }

    public void processPayment() {
        System.out.println("Processing payment of $" + calculateFinalPrice() + " via " + paymentMethod);
    }

    public void issueCertificate() {
        if (certificateIncluded) {
            System.out.println("Certificate issued for completion of: " + courseName);
        } else {
            System.out.println("No certificate available for this course");
        }
    }

    public double getFee() {
        return fee;
    }

    public double getDiscount() {
        return discount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isCertificateIncluded() {
        return certificateIncluded;
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        System.out.println("=== Educational Course Hierarchy System ===\n");

        Course course1 = new Course("Basic Programming", 40, "Dr. Smith", "Beginner");
        OnlineCourse course2 = new OnlineCourse("Web Development", 60, "Jane Doe", "Intermediate",
                "Zoom", true, "zoom.us/webdev", 50);
        PaidOnlineCourse course3 = new PaidOnlineCourse("Advanced AI", 80, "Prof. Johnson", "Advanced",
                "Coursera", false, "coursera.com/ai", 25,
                299.99, 20.0, "Credit Card", true);

        System.out.println("1. Basic Course Information:");
        course1.displayCourseInfo();
        course1.startCourse();
        System.out.println();

        System.out.println("2. Online Course Information:");
        course2.displayCourseInfo();
        course2.startCourse();
        course2.joinLiveSession();
        System.out.println();

        System.out.println("3. Paid Online Course Information:");
        course3.displayCourseInfo();
        course3.startCourse();
        course3.processPayment();
        course3.issueCertificate();
        System.out.println();

        System.out.println("4. Course Catalog Summary:");
        Course[] courses = { course1, course2, course3 };
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName() + " (" + course.getDuration() + " hours)");
        }

        System.out.println("\n=== End of Course Hierarchy Demo ===");
    }
}
