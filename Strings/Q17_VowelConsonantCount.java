import java.util.Scanner;

public class Q17_VowelConsonantCount {

    public static String charType(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1)
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVowelsConsonants(String text) {
        int vowel = 0, consonant = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = charType(text.charAt(i));
            if (type.equals("Vowel"))
                vowel++;
            else if (type.equals("Consonant"))
                consonant++;
        }
        return new int[] { vowel, consonant };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        int[] count = countVowelsConsonants(input);
        System.out.println("Vowels: " + count[0]);
        System.out.println("Consonants: " + count[1]);
        sc.close();
    }
}
