import java.util.Scanner;

class Q5_UniqueCharFrequency {

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
            if (isUnique)
                unique[idx++] = ch;
        }

        char[] result = new char[idx];
        System.arraycopy(unique, 0, result, 0, idx);
        return result;
    }

    public static String[][] getFrequencyUsingUnique(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] unique = findUniqueChars(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] output = getFrequencyUsingUnique(input);
        System.out.println("Char\tFrequency");
        for (String[] row : output) {
            System.out.println(row[0] + "\t" + row[1]);
        }
        sc.close();
    }
}
