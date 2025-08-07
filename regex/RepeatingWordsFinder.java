import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class RepeatingWordsFinder {
    private static final String WORD_REGEX = "\\b(\\w+)\\s+\\1\\b";
    private static final Pattern WORD_PATTERN = Pattern.compile(WORD_REGEX);

    public static List<String> findRepeatingWords(String text) {
        Set<String> repeatingWords = new HashSet<>();
        Matcher matcher = WORD_PATTERN.matcher(text);

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }

        return new ArrayList<>(repeatingWords);
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        List<String> repeatingWords = findRepeatingWords(text);

        System.out.println("Repeating words:");
        System.out.println(String.join(", ", repeatingWords));
    }
}
