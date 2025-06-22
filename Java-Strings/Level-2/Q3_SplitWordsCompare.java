import java.util.Scanner;

class Q3_SplitWordsCompare {
    public static String[] manualSplit(String str) {
        int spaceCount = 0;
        for (char ch : str.toCharArray()) {
            if (ch == ' ')
                spaceCount++;
        }

        String[] words = new String[spaceCount + 1];
        String word = "";
        int idx = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                words[idx++] = word;
                word = "";
            }
        }
        words[idx] = word;
        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] manual = manualSplit(sentence);
        String[] builtin = sentence.split(" ");
        boolean same = compareArrays(manual, builtin);

        System.out.println("Manual Split:");
        for (String w : manual)
            System.out.println(w);

        System.out.println("\nAre both methods equal? " + same);
        sc.close();
    }
}
