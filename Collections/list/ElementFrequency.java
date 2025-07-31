package list;

import java.util.*;

public class ElementFrequency {

    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = findFrequency(list);
        System.out.println("Input: " + list);
        System.out.println("Output: " + result);
    }
}
