import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class ProgrammingLanguageExtractor {
    private static final String[] LANGUAGES = { "Java", "Python", "JavaScript", "Go", "C\\+\\+", "C#", "Ruby", "PHP",
            "Swift", "Kotlin" };

    public static List<String> extractProgrammingLanguages(String text) {
        List<String> foundLanguages = new ArrayList<>();

        for (String lang : LANGUAGES) {
            String regex = "\\b" + lang + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                foundLanguages.add(lang.replace("\\+\\+", "++").replace("\\#", "#"));
            }
        }

        return foundLanguages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = extractProgrammingLanguages(text);

        System.out.println("Extracted programming languages:");
        System.out.println(String.join(", ", languages));
    }
}
