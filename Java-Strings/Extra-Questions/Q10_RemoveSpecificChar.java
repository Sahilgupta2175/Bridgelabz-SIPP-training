public class Q10_RemoveSpecificChar {
    public static void main(String[] args) {
        String input = "Hello World";
        char toRemove = 'l';
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c != toRemove) {
                result.append(c);
            }
        }
        System.out.println("Modified String: " + result);
    }
}
