public class Q3_PalindromeChecker {

    static class PalindromeChecker {
        String text;

        public PalindromeChecker(String text) {
            this.text = text;
        }

        public boolean isPalindrome() {
            String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String reversed = new StringBuilder(clean).reverse().toString();
            return clean.equals(reversed);
        }

        public void displayResult() {
            System.out.println("Text: " + text);
            if (isPalindrome())
                System.out.println("Result: Palindrome");
            else
                System.out.println("Result: Not a Palindrome");
        }
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker("Madam");
        checker.displayResult();
    }
}
