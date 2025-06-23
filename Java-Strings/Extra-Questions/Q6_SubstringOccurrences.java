public class Q6_SubstringOccurrences {
    public static void main(String[] args) {
        String str = "abababab", sub = "ab";
        int count = 0, index = 0;
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        System.out.println("Occurrences: " + count);
    }
}
