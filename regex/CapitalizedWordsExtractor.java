import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CapitalizedWordsExtractor {
    private static final String CAPITALIZED_WORD_REGEX = "\\b[A-Z][a-z]+\\b";
    private static final Pattern CAPITALIZED_WORD_PATTERN = Pattern.compile(CAPITALIZED_WORD_REGEX);

    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = CAPITALIZED_WORD_PATTERN.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = extractCapitalizedWords(text);

        System.out.println("Extracted capitalized words:");
        System.out.println(String.join(", ", words));
    }
}
