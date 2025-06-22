import java.util.Scanner;

class Q4_CharFrequency {

    public static String[][] getCharFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        boolean[] printed = new boolean[256];
        String[][] result = new String[text.length()][2];
        int idx = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!printed[ch]) {
                result[idx][0] = String.valueOf(ch);
                result[idx][1] = String.valueOf(freq[ch]);
                printed[ch] = true;
                idx++;
            }
        }

        String[][] output = new String[idx][2];
        System.arraycopy(result, 0, output, 0, idx);
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] freq = getCharFrequency(input);
        System.out.println("Char\tFrequency");
        for (String[] row : freq) {
            System.out.println(row[0] + "\t" + row[1]);
        }
        sc.close();
    }
}
