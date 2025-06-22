class Q5_ShortestLongestWord {

    public static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(words[i].length());
        }
        return result;
    }

    public static int[] findMinMaxIndex(String[][] data) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIdx = 0, maxIdx = 0;

        for (int i = 0; i < data.length; i++) {
            int len = Integer.parseInt(data[i][1]);
            if (len < min) {
                min = len;
                minIdx = i;
            }
            if (len > max) {
                max = len;
                maxIdx = i;
            }
        }
        return new int[] { minIdx, maxIdx };
    }

    public static void main(String[] args) {
        String sentence = "AI will transform the future of education and creativity";
        String[] words = sentence.split(" ");
        String[][] data = wordWithLength(words);
        int[] indices = findMinMaxIndex(data);

        System.out.println("Shortest: " + data[indices[0]][0]);
        System.out.println("Longest : " + data[indices[1]][0]);
    }
}