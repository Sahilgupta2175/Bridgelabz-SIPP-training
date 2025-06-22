import java.util.Scanner;

class Q6_FrequencyNestedLoop {

    public static String[][] frequencyByNestedLoop(String str) {
        char[] chars = str.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            if (chars[i] == '0')
                continue;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        int count = 0;
        for (char c : chars) {
            if (c != '0')
                count++;
        }

        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index][0] = String.valueOf(chars[i]);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] result = frequencyByNestedLoop(input);
        System.out.println("Char\tFrequency");
        for (String[] row : result) {
            System.out.println(row[0] + "\t" + row[1]);
        }
        sc.close();
    }
}
