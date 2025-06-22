public class Q3_GradeCalculator {
    public static void main(String[] args) {
        int physics = 85, chemistry = 75, maths = 90;
        int total = physics + chemistry + maths;
        double average = total / 3.0;

        System.out.println("Average Marks: " + average);

        if (average >= 90) {
            System.out.println("Grade A: Excellent");
        } else if (average >= 75) {
            System.out.println("Grade B: Very Good");
        } else if (average >= 60) {
            System.out.println("Grade C: Good");
        } else if (average >= 50) {
            System.out.println("Grade D: Pass");
        } else {
            System.out.println("Grade F: Fail");
        }
    }
}
