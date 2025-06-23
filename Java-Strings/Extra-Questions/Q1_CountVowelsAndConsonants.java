public class Q1_CountVowelsAndConsonants {
    public static void main(String[] args) {
        String input = "Hello World";
        int vowels = 0, consonants = 0;
        input = input.toLowerCase();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }
}
