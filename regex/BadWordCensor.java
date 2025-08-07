import java.util.regex.Pattern;

public class BadWordCensor {
    private static final String[] BAD_WORDS = { "damn", "stupid", "bad" };

    public static String censorBadWords(String text) {
        String result = text;

        for (String badWord : BAD_WORDS) {
            String regex = "\\b" + Pattern.quote(badWord) + "\\b";
            result = result.replaceAll("(?i)" + regex, "****");
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String censored = censorBadWords(text);

        System.out.println("Original: " + text);
        System.out.println("Censored: " + censored);
    }
}
