import java.util.Scanner;

public class Q11_SplitTextAndLength {
    public static String[] manualSplit(String text) {
        text = text.trim() + " ";
        StringBuilder word = new StringBuilder();
        java.util.ArrayList<String> words = new java.util.ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.setLength(0);
                }
            }
        }
        return words.toArray(new String[0]);
    }

    public static int getLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count);
                count++;
            }
        } catch (Exception ignored) {
        }
        return count;
    }

    public static String[][] wordLength2D(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void display(String[][] array) {
        System.out.println("Word\tLength");
        for (String[] row : array) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = manualSplit(input);
        String[][] result = wordLength2D(words);
        display(result);
        sc.close();
    }
}
