import java.util.Scanner;

public class Q3_ArmstrongCheck {

    public static boolean isArmstrong(int num) {
        int sum = 0, original = num;
        int digits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to check Armstrong: ");
        int number = sc.nextInt();

        System.out.println("Is Armstrong? " + isArmstrong(number));
        sc.close();
    }
}
