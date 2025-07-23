package map;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> wordCount = new HashMap<>();

        String[] words = text.toLowerCase()
                .replaceAll("[^a-zA-Z\\s]", "")
                .split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        return wordCount;
    }

    public static Map<String, Integer> countWordFrequencyFromFile(String filename) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Map<String, Integer> lineCount = countWordFrequency(line);
                for (Map.Entry<String, Integer> entry : lineCount.entrySet()) {
                    wordCount.put(entry.getKey(),
                            wordCount.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return wordCount;
    }

    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        Map<String, Integer> result = countWordFrequency(text);
        System.out.println("Input: \"" + text + "\"");
        System.out.println("Output: " + result);
    }
}
