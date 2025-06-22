import java.util.Scanner;

class Q7_CharacterTypes {

    public static String getCharType(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        } else if (ch >= 'a' && ch <= 'z') {
            return "Consonant";
        } else if (ch >= '0' && ch <= '9') {
            return "Digit";
        } else if (ch == ' ') {
            return "Space";
        } else {
            return "Special";
        }
    }

    public static String[][] getCharacterTypes(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch); // Using the local method instead
        }
        return result;
    }

    public static void display(String[][] data) {
        System.out.println("Char\tType");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] result = getCharacterTypes(input);
        display(result);
        sc.close();
    }
}