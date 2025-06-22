public class Q1_LeapYearMultipleIfElse {
    public static void main(String[] args) {
        int year = 2000;
        if (year >= 1582) {
            if (year % 400 == 0) {
                System.out.println("Leap Year");
            } else if (year % 100 == 0) {
                System.out.println("Not a Leap Year");
            } else if (year % 4 == 0) {
                System.out.println("Leap Year");
            } else {
                System.out.println("Not a Leap Year");
            }
        } else {
            System.out.println("Year should be ≥ 1582");
        }
    }
}
