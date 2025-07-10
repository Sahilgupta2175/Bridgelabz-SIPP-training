public class SearchWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog",
                "Java is a powerful programming language",
                "Machine learning is revolutionizing technology",
                "Data structures and algorithms are fundamental",
                "Software development requires continuous learning"
        };

        String[] searchWords = { "Java", "fox", "Python", "learning" };

        for (String word : searchWords) {
            String result = findSentenceWithWord(sentences, word);
            System.out.println("Searching for '" + word + "':");
            System.out.println("Result: " + result);
            System.out.println();
        }
    }
}
