public class ConcatenateStrings {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();

        for (String str : strings) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = { "Hello", " ", "World", "!", " ", "Java", " ", "Programming" };
        String result = concatenateStrings(strings);
        System.out.println("Concatenated result: " + result);
    }
}
