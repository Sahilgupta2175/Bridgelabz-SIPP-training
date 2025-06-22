import java.util.Scanner;

class Q2_UniqueCharacters {

    public static char[] findUniqueChars(String text) {
        int len = text.length();
        char[] unique = new char[len];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[idx++] = ch;
            }
        }

        char[] result = new char[idx];
        System.arraycopy(unique, 0, result, 0, idx);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        char[] unique = findUniqueChars(input);
        System.out.print("Unique Characters: ");
        for (char ch : unique) {
            System.out.print(ch + " ");
        }
        sc.close();
    }
}
