import java.util.Scanner;

public class Q4_DuckNumberCheck {

    public static boolean isDuckNumber(String number) {
        return number.contains("0") && number.charAt(0) != '0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to check Duck number: ");
        String num = sc.next();

        System.out.println("Is Duck Number? " + isDuckNumber(num));
        sc.close();
    }
}
