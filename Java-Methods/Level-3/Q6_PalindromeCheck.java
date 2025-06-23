import java.util.Scanner;

public class Q6_PalindromeCheck {

    public static boolean isPalindrome(int num) {
        int reversed = 0, original = num;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number to check Palindrome: ");
        int number = sc.nextInt();

        System.out.println("Is Palindrome? " + isPalindrome(number));
        sc.close();
    }
}
