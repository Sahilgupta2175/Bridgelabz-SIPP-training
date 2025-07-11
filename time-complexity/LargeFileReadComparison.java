import java.io.*;

public class LargeFileReadComparison {

    public static void main(String[] args) {
        String filePath = "largefile.txt";

        System.out.println("Reading File: " + filePath);

        long fileReaderTime = readUsingFileReader(filePath);
        System.out.println("Time using FileReader: " + fileReaderTime + " ms");

        long inputStreamReaderTime = readUsingInputStreamReader(filePath);
        System.out.println("Time using InputStreamReader: " + inputStreamReaderTime + " ms");
    }

    public static long readUsingFileReader(String filePath) {
        long startTime = System.currentTimeMillis();

        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {
            }
        } catch (IOException e) {
            System.err.println("FileReader Error: " + e.getMessage());
        }

        return System.currentTimeMillis() - startTime;
    }

    public static long readUsingInputStreamReader(String filePath) {
        long startTime = System.currentTimeMillis();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {
            }
        } catch (IOException e) {
            System.err.println("InputStreamReader Error: " + e.getMessage());
        }

        return System.currentTimeMillis() - startTime;
    }
}
