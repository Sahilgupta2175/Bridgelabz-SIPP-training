import java.util.Scanner;

public class Q5_StringToCharArrayCompare {
    public static char[] manualToCharArray(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.next();

        char[] manual = manualToCharArray(input);
        char[] builtin = input.toCharArray();

        System.out.println("Match: " + compareCharArrays(manual, builtin));
        sc.close();
    }
}
