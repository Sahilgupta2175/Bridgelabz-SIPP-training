import java.util.List;

public class RegexTestRunner {
    public static void main(String[] args) {
        System.out.println("=== Java Regex Practice Problems Solutions ===\n");

        System.out.println("1. Username Validation:");
        String[] usernames = { "user_123", "123user", "us", "validUser", "invalid-name" };
        for (String username : usernames) {
            System.out.println(username + " -> " + (UsernameValidator.isValidUsername(username) ? "Valid" : "Invalid"));
        }
        System.out.println();

        System.out.println("2. License Plate Validation:");
        String[] plates = { "AB1234", "A12345", "ab1234", "ABC123" };
        for (String plate : plates) {
            System.out
                    .println(plate + " -> " + (LicensePlateValidator.isValidLicensePlate(plate) ? "Valid" : "Invalid"));
        }
        System.out.println();

        System.out.println("3. Hex Color Validation:");
        String[] colors = { "#FFA500", "#ff4500", "#123", "#GGHHII" };
        for (String color : colors) {
            System.out.println(color + " -> " + (HexColorValidator.isValidHexColor(color) ? "Valid" : "Invalid"));
        }
        System.out.println();

        System.out.println("4. Email Extraction:");
        String emailText = "Contact us at support@example.com and info@company.org";
        List<String> emails = EmailExtractor.extractEmails(emailText);
        System.out.println("Text: " + emailText);
        System.out.println("Emails: " + String.join(", ", emails));
        System.out.println();

        System.out.println("5. Capitalized Words Extraction:");
        String capText = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> capWords = CapitalizedWordsExtractor.extractCapitalizedWords(capText);
        System.out.println("Text: " + capText);
        System.out.println("Capitalized words: " + String.join(", ", capWords));
        System.out.println();

        System.out.println("6. Date Extraction:");
        String dateText = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates = DateExtractor.extractDates(dateText);
        System.out.println("Text: " + dateText);
        System.out.println("Dates: " + String.join(", ", dates));
        System.out.println();

        System.out.println("7. Link Extraction:");
        String linkText = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = LinkExtractor.extractLinks(linkText);
        System.out.println("Text: " + linkText);
        System.out.println("Links: " + String.join(", ", links));
        System.out.println();

        System.out.println("8. Multiple Space Replacement:");
        String spaceText = "This    is     an   example    with  multiple   spaces.";
        String fixedSpaces = SpaceReplacer.replaceMultipleSpaces(spaceText);
        System.out.println("Original: \"" + spaceText + "\"");
        System.out.println("Fixed: \"" + fixedSpaces + "\"");
        System.out.println();

        System.out.println("9. Bad Word Censoring:");
        String badText = "This is a damn bad example with some stupid words.";
        String censoredText = BadWordCensor.censorBadWords(badText);
        System.out.println("Original: " + badText);
        System.out.println("Censored: " + censoredText);
        System.out.println();

        System.out.println("10. IP Address Validation:");
        String[] ips = { "192.168.1.1", "255.255.255.255", "256.1.1.1", "192.168.1" };
        for (String ip : ips) {
            System.out.println(ip + " -> " + (IPAddressValidator.isValidIPAddress(ip) ? "Valid" : "Invalid"));
        }
        System.out.println();

        System.out.println("11. Credit Card Validation:");
        String[] cards = { "4123456789012345", "5123456789012345", "3123456789012345" };
        for (String card : cards) {
            System.out.println(card + " -> " + CreditCardValidator.validateCreditCard(card));
        }
        System.out.println();

        System.out.println("12. Programming Language Extraction:");
        String langText = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = ProgrammingLanguageExtractor.extractProgrammingLanguages(langText);
        System.out.println("Text: " + langText);
        System.out.println("Languages: " + String.join(", ", languages));
        System.out.println();

        System.out.println("13. Currency Value Extraction:");
        String currencyText = "The price is $45.99, and the discount is 10.50.";
        List<String> currencies = CurrencyExtractor.extractCurrencyValues(currencyText);
        System.out.println("Text: " + currencyText);
        System.out.println("Currency values: " + String.join(", ", currencies));
        System.out.println();

        System.out.println("14. Repeating Words Finder:");
        String repeatText = "This is is a repeated repeated word test.";
        List<String> repeatingWords = RepeatingWordsFinder.findRepeatingWords(repeatText);
        System.out.println("Text: " + repeatText);
        System.out.println("Repeating words: " + String.join(", ", repeatingWords));
        System.out.println();

        System.out.println("15. SSN Validation:");
        String[] ssnTexts = { "My SSN is 123-45-6789.", "Invalid SSN: 123456789" };
        for (String ssnText : ssnTexts) {
            System.out.println("Text: " + ssnText);
            System.out.println("Result: " + SSNValidator.extractAndValidateSSN(ssnText));
        }
    }
}
