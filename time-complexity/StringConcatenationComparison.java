public class StringConcatenationComparison {

    public static void main(String[] args) {
        System.out.println("=== Problem 3: String Concatenation Performance ===");
        System.out.println("String O(N²) vs StringBuilder O(N) vs StringBuffer O(N)");
        System.out.println("====================================================\n");

        testStringConcatenation();
    }

    public static void testStringConcatenation() {
        int[] sizes = { 1000, 10000, 100000 };

        System.out.printf("%-15s %-15s %-15s %-15s%n", "Operations", "String", "StringBuilder", "StringBuffer");
        System.out.println("----------------------------------------------------------------");

        for (int size : sizes) {
            String stringTime = "Too slow";
            if (size <= 10000) {
                long startTime = System.nanoTime();
                String result1 = testStringConcatenation(size);
                long endTime = System.nanoTime();
                stringTime = formatTime(endTime - startTime);

                System.out.println("  String result length: " + result1.length());
            }

            long startTime = System.nanoTime();
            String result2 = testStringBuilder(size);
            long endTime = System.nanoTime();
            String stringBuilderTime = formatTime(endTime - startTime);

            System.out.println("  StringBuilder result length: " + result2.length());

            startTime = System.nanoTime();
            String result3 = testStringBuffer(size);
            endTime = System.nanoTime();
            String stringBufferTime = formatTime(endTime - startTime);

            System.out.println("  StringBuffer result length: " + result3.length());

            System.out.printf("%-15d %-15s %-15s %-15s%n",
                    size, stringTime, stringBuilderTime, stringBufferTime);
            System.out.println();
        }

        System.out.println("Analysis:");
        System.out.println("- String: O(N²) - Creates new object for each concatenation");
        System.out.println("- StringBuilder: O(N) - Mutable, efficient for single-threaded use");
        System.out.println("- StringBuffer: O(N) - Thread-safe, slightly slower than StringBuilder");
        System.out.println("- Use StringBuilder for single-threaded, StringBuffer for multi-threaded");

        demonstrateMemoryUsage();
    }

    public static String testStringConcatenation(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "Hello" + i + " ";
        }
        return result;
    }

    public static String testStringBuilder(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("Hello").append(i).append(" ");
        }
        return sb.toString();
    }

    public static String testStringBuffer(int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("Hello").append(i).append(" ");
        }
        return sb.toString();
    }

    public static void demonstrateMemoryUsage() {
        System.out.println("\n=== Memory Usage Demonstration ===");

        int operations = 5000;

        System.gc();
        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long startTime = System.nanoTime();
        String result1 = testStringConcatenation(operations);
        long endTime = System.nanoTime();

        long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("String concatenation:");
        System.out.println("  Time: " + formatTime(endTime - startTime));
        System.out.println("  Memory used: " + (memoryAfter - memoryBefore) / 1024 + " KB");

        System.gc();
        memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        startTime = System.nanoTime();
        String result2 = testStringBuilder(operations);
        endTime = System.nanoTime();

        memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("\nStringBuilder:");
        System.out.println("  Time: " + formatTime(endTime - startTime));
        System.out.println("  Memory used: " + (memoryAfter - memoryBefore) / 1024 + " KB");

        demonstrateCapacityManagement();
    }

    public static void demonstrateCapacityManagement() {
        System.out.println("\n=== StringBuilder Capacity Management ===");

        StringBuilder sb = new StringBuilder();
        System.out.println("Initial capacity: " + sb.capacity());

        for (int i = 0; i < 10; i++) {
            sb.append("Hello World! ");
            System.out.println("After " + (i + 1) + " appends - Length: " +
                    sb.length() + ", Capacity: " + sb.capacity());
        }

        System.out.println("\n=== Pre-sized StringBuilder ===");
        StringBuilder preSized = new StringBuilder(1000);
        System.out.println("Pre-sized capacity: " + preSized.capacity());

        for (int i = 0; i < 10; i++) {
            preSized.append("Hello World! ");
        }
        System.out.println("After appends - Length: " + preSized.length() +
                ", Capacity: " + preSized.capacity());
    }

    public static String formatTime(long nanoTime) {
        if (nanoTime < 1_000) {
            return nanoTime + " ns";
        } else if (nanoTime < 1_000_000) {
            return String.format("%.2f μs", nanoTime / 1_000.0);
        } else if (nanoTime < 1_000_000_000) {
            return String.format("%.2f ms", nanoTime / 1_000_000.0);
        } else {
            return String.format("%.2f s", nanoTime / 1_000_000_000.0);
        }
    }
}
