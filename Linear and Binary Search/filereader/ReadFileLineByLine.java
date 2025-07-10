import java.io.*;

public class ReadFileLineByLine {
    public static void readFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int lineNumber = 1;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "sample.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("This is line 1\n");
            writer.write("This is line 2\n");
            writer.write("This is line 3\n");
            writer.write("Java programming is fun\n");
            System.out.println("Sample file created: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }

        System.out.println("\nReading file line by line:");
        readFile(fileName);
    }
}
