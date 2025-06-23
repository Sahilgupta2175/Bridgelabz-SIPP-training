public class Q9_MostFrequentCharacter {
    public static void main(String[] args) {
        String str = "success";
        int[] freq = new int[256];
        for (char c : str.toCharArray())
            freq[c]++;
        int max = 0;
        char result = ' ';
        for (char c : str.toCharArray()) {
            if (freq[c] > max) {
                max = freq[c];
                result = c;
            }
        }
        System.out.println("Most Frequent Character: " + result);
    }
}
