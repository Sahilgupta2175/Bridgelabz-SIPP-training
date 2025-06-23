public class Q12_ReplaceWord {
    public static String replace(String sentence, String target, String replacement) {
        return sentence.replaceAll("\\b" + target + "\\b", replacement);
    }

    public static void main(String[] args) {
        String sentence = "I love coding in Java. Java is fun.";
        String updated = replace(sentence, "Java", "Python");
        System.out.println("Modified Sentence: " + updated);
    }
}
