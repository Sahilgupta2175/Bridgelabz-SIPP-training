import java.util.Scanner;
public class Q33_ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), original = number, sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }
        if (sum == original)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not an Armstrong Number");
    }
}
