import java.util.Scanner;

public class Q5_HarshadNumberCheck {

    public static boolean isHarshad(int num) {
        int sum = 0, original = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return original % sum == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to check Harshad: ");
        int number = sc.nextInt();

        System.out.println("Is Harshad? " + isHarshad(number));
        sc.close();
    }
}
