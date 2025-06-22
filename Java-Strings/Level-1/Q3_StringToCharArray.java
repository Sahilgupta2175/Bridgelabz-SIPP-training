import java.util.Scanner;

class Q3_StringToCharArray {
    public static char[] customToCharArray(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] manual = customToCharArray(text);
        char[] builtin = text.toCharArray();

        boolean same = compareCharArrays(manual, builtin);
        System.out.println("Are char arrays same? " + same);
        sc.close();
    }
}
