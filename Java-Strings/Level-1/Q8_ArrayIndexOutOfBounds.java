class Q8_ArrayIndexOutOfBounds {
    public static void generateException(String[] names) {
        System.out.println(names[names.length]); // Invalid index
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] names = { "Sahil", "Amit", "Neha" };
        // generateException(names); // Unsafe
        handleException(names); // Safe
    }
}
