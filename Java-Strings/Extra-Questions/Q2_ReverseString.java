public class Q2_ReverseString {
    public static void main(String[] args) {
        String str = "OpenAI";
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("Reversed: " + reversed);
    }
}
