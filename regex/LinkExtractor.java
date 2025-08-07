import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {
    private static final String LINK_REGEX = "https?://[\\w.-]+(?:/[\\w._~:/?#@!$&'()*+,;=%-]*)*";
    private static final Pattern LINK_PATTERN = Pattern.compile(LINK_REGEX);

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher matcher = LINK_PATTERN.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = extractLinks(text);

        System.out.println("Extracted links:");
        System.out.println(String.join(", ", links));
    }
}
