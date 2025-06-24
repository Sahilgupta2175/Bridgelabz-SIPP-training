public class Q8_Course {
    private String courseName;
    private int duration;
    private double fee;

    private static String instituteName = "Tech Learning Institute";

    public Q8_Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Details:");
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    public static String getInstituteName() {
        return instituteName;
    }

    public static void main(String[] args) {
        System.out.println("Initial Institute Name: " + Q8_Course.getInstituteName());

        Q8_Course course1 = new Q8_Course("Java Programming", 12, 299.99);
        Q8_Course course2 = new Q8_Course("Web Development", 8, 249.99);
        Q8_Course course3 = new Q8_Course("Data Science", 16, 399.99);

        System.out.println("\nCourse Information (Before Institute Name Change):");
        course1.displayCourseDetails();

        System.out.println("\nUpdating Institute Name...");
        Q8_Course.updateInstituteName("Advanced Tech Academy");

        System.out.println("\nCourse Information (After Institute Name Change):");
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
        System.out.println();
        course3.displayCourseDetails();
    }
}
