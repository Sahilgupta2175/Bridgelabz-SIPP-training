import java.io.*;

public class ComprehensiveChallenge {

    public static void performStringConcatenationTest() {
        System.out.println("=== String Concatenation Performance Test ===");

        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        long sbTime = System.nanoTime() - startTime;

        StringBuffer sbuf = new StringBuffer();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sbuf.append("hello");
        }
        long sbufTime = System.nanoTime() - startTime;

        System.out.println("StringBuilder time: " + sbTime + " nanoseconds");
        System.out.println("StringBuffer time: " + sbufTime + " nanoseconds");
        System.out.println("StringBuilder is " + (sbufTime > sbTime ? "faster" : "slower") + " than StringBuffer");
    }

    public static void performFileReadingTest() {
        System.out.println("\n=== File Reading Performance Test ===");

        String fileName = "large_sample.txt";
        createLargeSampleFile(fileName);

        long startTime = System.nanoTime();
        int wordCountFileReader = countWordsWithFileReader(fileName);
        long fileReaderTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        int wordCountInputStreamReader = countWordsWithInputStreamReader(fileName);
        long inputStreamReaderTime = System.nanoTime() - startTime;

        System.out.println("FileReader - Words: " + wordCountFileReader + ", Time: " + fileReaderTime + " nanoseconds");
        System.out.println("InputStreamReader - Words: " + wordCountInputStreamReader + ", Time: "
                + inputStreamReaderTime + " nanoseconds");
    }

    private static void createLargeSampleFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 0; i < 10000; i++) {
                writer.write("This is line " + i + " with multiple words for testing performance. ");
                writer.write("Java programming language is powerful and versatile. ");
                writer.write("File reading operations can be optimized using different approaches.\n");
            }
            System.out.println("Large sample file created: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating large sample file: " + e.getMessage());
        }
    }

    private static int countWordsWithFileReader(String fileName) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
        } catch (IOException e) {
            System.err.println("Error with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    private static int countWordsWithInputStreamReader(String fileName) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(isr)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
        } catch (IOException e) {
            System.err.println("Error with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }

    public static void main(String[] args) {
        System.out.println(
                "Comprehensive Challenge: Comparing StringBuilder, StringBuffer, FileReader, and InputStreamReader\n");

        performStringConcatenationTest();
        performFileReadingTest();

        System.out.println("\n=== Challenge Complete ===");
    }
}
