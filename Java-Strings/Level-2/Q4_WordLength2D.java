import java.util.Scanner;

class Q4_WordLength2D {

    public static String[] splitWords(String str) {
        return str.trim().split("\\s+");
    }

    public static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(words[i].length());
        }
        return result;
    }

    public static void display(String[][] data) {
        System.out.println("Word\tLength");
        for (String[] entry : data) {
            System.out.println(entry[0] + "\t" + entry[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] result = wordWithLength(words);
        display(result);
        sc.close();
    }
}
