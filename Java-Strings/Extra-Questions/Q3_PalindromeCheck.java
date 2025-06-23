public class Q3_PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println(str.equals(reversed) ? "Palindrome" : "Not Palindrome");
    }
}
