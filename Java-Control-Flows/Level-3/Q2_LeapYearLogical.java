public class Q2_LeapYearLogical {
    public static void main(String[] args) {
        int year = 2000;
        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Not a Leap Year or Invalid Year");
        }
    }
}
