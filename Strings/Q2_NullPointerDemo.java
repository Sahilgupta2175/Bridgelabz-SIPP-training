public class Q2_NullPointerDemo {
    @SuppressWarnings("null")
    public static void generateException() {
        String text = null;
        System.out.println("Length: " + text.length()); // NPE
    }

    @SuppressWarnings("null")
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught Exception: " + e);
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        try {
            generateException();
        } catch (Exception ignored) {
        }
        handleException();
    }
}
