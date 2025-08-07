import java.util.regex.Pattern;

public class SpaceReplacer {
    private static final String MULTIPLE_SPACES_REGEX = "\\s+";
    private static final Pattern MULTIPLE_SPACES_PATTERN = Pattern.compile(MULTIPLE_SPACES_REGEX);

    public static String replaceMultipleSpaces(String text) {
        return MULTIPLE_SPACES_PATTERN.matcher(text).replaceAll(" ");
    }

    public static void main(String[] args) {
        String text = "This    is     an   example    with  multiple   spaces.";
        String result = replaceMultipleSpaces(text);

        System.out.println("Original: \"" + text + "\"");
        System.out.println("Modified: \"" + result + "\"");
    }
}
