import java.util.Scanner;

class Q8_AnagramChecker {

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i)]++;
            freq2[s2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();
        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        System.out.println("Are Anagrams? " + areAnagrams(text1, text2));
        sc.close();
    }
}
