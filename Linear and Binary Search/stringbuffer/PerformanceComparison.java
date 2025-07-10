public class PerformanceComparison {
    public static void stringBufferTest() {
        StringBuffer sb = new StringBuffer();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("StringBuffer time: " + duration + " nanoseconds");
    }

    public static void stringBuilderTest() {
        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("StringBuilder time: " + duration + " nanoseconds");
    }

    public static void main(String[] args) {
        System.out.println("Performance Comparison for 1,000,000 string concatenations:");

        stringBufferTest();
        stringBuilderTest();

        System.out.println("\nNote: StringBuilder is typically faster as it's not synchronized.");
    }
}
