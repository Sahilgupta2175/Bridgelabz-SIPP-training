import java.util.Scanner;

class Q1_FindCharacterOccurrences {

    public static int[] findAllIndexes(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch)
                count++;
        }

        int[] indexes = new int[count];
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                indexes[j++] = i;
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter character to find: ");
        char ch = sc.next().charAt(0);

        int[] result = findAllIndexes(text, ch);
        System.out.print("Indexes: ");
        for (int index : result) {
            System.out.print(index + " ");
        }
        sc.close();
    }
}
