import java.io.*;

public class ConvertByteToCharStream {
    public static void readBinaryFileAsCharacters(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

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
        String fileName = "binary_sample.txt";

        try (FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8")) {

            osw.write("This is UTF-8 encoded text.\n");
            osw.write("Special characters: αβγδε\n");
            osw.write("Numbers: 12345\n");
            osw.write("Mixed content: Hello世界\n");
            System.out.println("Binary sample file created: " + fileName);

        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }

        System.out.println("\nReading binary file as character stream:");
        readBinaryFileAsCharacters(fileName);
    }
}
