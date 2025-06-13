import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the month number (1-12): ");
        int month = input.nextInt();
        System.out.println("Enter the day number (1-31): ");
        int day = input.nextInt();
        boolean isSpring = false;

        if (month == 3 && day >= 20) {
            isSpring = true;
        } else if (month == 4 || month == 5) {
            isSpring = true;
        } else if (month == 6 && day < 21) {
            isSpring = true;
        }

        if (isSpring) {
            System.out.println("It is Spring season.");
        } else {
            System.out.println("Not a Spring season.");
        }

        input.close();
    }
}
