import java.time.LocalDate;
import java.util.Scanner;

public class Q4_DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(scanner.nextLine());

        if (date1.isBefore(date2)) {
            System.out.println("First date is before second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after second date.");
        } else {
            System.out.println("Both dates are the same.");
        }
        scanner.close();
    }
}
