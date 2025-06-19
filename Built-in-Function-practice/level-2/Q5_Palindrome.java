import java.util.Scanner;

public class Q5_Palindrome {
    public static boolean isPalindrome(String text) {
        int l = 0, r = text.length() - 1;
        while (l < r) {
            if (text.charAt(l) != text.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("It's a palindrome.");
        } else {
            System.out.println("Not a palindrome.");
        }
        sc.close();
    }
}
