import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CurrencyExtractor {
    private static final String CURRENCY_REGEX = "\\$?\\d+\\.\\d{2}";
    private static final Pattern CURRENCY_PATTERN = Pattern.compile(CURRENCY_REGEX);

    public static List<String> extractCurrencyValues(String text) {
        List<String> currencies = new ArrayList<>();
        Matcher matcher = CURRENCY_PATTERN.matcher(text);

        while (matcher.find()) {
            currencies.add(matcher.group());
        }

        return currencies;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> currencies = extractCurrencyValues(text);

        System.out.println("Extracted currency values:");
        System.out.println(String.join(", ", currencies));
    }
}
