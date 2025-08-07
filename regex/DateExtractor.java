import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class DateExtractor {
    private static final String DATE_REGEX = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher matcher = DATE_PATTERN.matcher(text);

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates = extractDates(text);

        System.out.println("Extracted dates:");
        System.out.println(String.join(", ", dates));
    }
}
