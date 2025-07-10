import java.io.*;

public class ReadUserInputToFile {
    public static void readUserInputAndWriteToFile(String fileName) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                FileWriter fileWriter = new FileWriter(fileName)) {

            String input;
            System.out.println("Enter text (type 'exit' to stop):");

            while (!(input = bufferedReader.readLine()).equals("exit")) {
                fileWriter.write(input + "\n");
                System.out.println("Input recorded. Enter more text (or 'exit' to stop):");
            }

            System.out.println("Input saved to file: " + fileName);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void demonstrateWithSampleInput(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            String[] sampleInputs = {
                    "Hello World",
                    "This is a test",
                    "Java programming",
                    "InputStreamReader example"
            };

            for (String input : sampleInputs) {
                fileWriter.write(input + "\n");
            }

            System.out.println("Sample input written to file: " + fileName);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            System.out.println("\nContent of the file:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "user_input.txt";

        System.out.println("Demonstrating with sample input:");
        demonstrateWithSampleInput(fileName);

        System.out.println("\n--- Uncomment the line below to enable interactive input ---");
        System.out.println("// readUserInputAndWriteToFile(fileName);");
    }
}
