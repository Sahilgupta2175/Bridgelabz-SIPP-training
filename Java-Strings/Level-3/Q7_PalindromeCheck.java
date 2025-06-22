import java.util.Scanner;

class Q7_PalindromeCheck {

    public static boolean isPalindromeLogic1(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end)
            return true;
        if (text.charAt(start) != text.charAt(end))
            return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reverse[i] = text.charAt(original.length - 1 - i);
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        System.out.println("Logic 1 (Iterative): " + isPalindromeLogic1(input));
        System.out.println("Logic 2 (Recursive): " + isPalindromeRecursive(input, 0, input.length() - 1));
        System.out.println("Logic 3 (CharArray): " + isPalindromeCharArray(input));
        sc.close();
    }
}
