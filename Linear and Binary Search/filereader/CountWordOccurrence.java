import java.io.*;

public class CountWordOccurrence {
    public static int countWordInFile(String fileName, String targetWord) {
        int count = 0;

        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");

                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (word.equals(targetWord.toLowerCase())) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String fileName = "word_count_sample.txt";
        String targetWord = "Java";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Java is a programming language.\n");
            writer.write("Java is object-oriented.\n");
            writer.write("Many developers love Java.\n");
            writer.write("Learning Java is essential for software development.\n");
            System.out.println("Sample file created: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }

        int count = countWordInFile(fileName, targetWord);
        System.out.println("\nThe word '" + targetWord + "' appears " + count + " times in the file.");
    }
}
