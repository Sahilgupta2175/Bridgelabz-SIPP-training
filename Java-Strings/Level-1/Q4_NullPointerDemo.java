class Q4_NullPointerDemo {
    public static void generateException() {
        String text = null;
        System.out.println("Length: " + text.length()); // throws exception
    }

    public static void handleException() {
        try {
            String text = null;
            System.out.println("Length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // generateException(); // Uncomment to see runtime crash
        handleException(); // Safe execution
    }
}
