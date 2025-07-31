package map;

import java.util.*;

public class MapOperations {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            invertedMap.putIfAbsent(value, new ArrayList<>());
            invertedMap.get(value).add(key);
        }

        return invertedMap;
    }

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map.isEmpty())
            return null;

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static <K> Map<K, Integer> mergeMaps(Map<K, Integer> map1, Map<K, Integer> map2) {
        Map<K, Integer> result = new HashMap<>(map1);

        for (Map.Entry<K, Integer> entry : map2.entrySet()) {
            result.put(entry.getKey(),
                    result.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        System.out.println("Original map: " + originalMap);
        System.out.println("Inverted map: " + invertMap(originalMap));

        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("A", 10);
        valueMap.put("B", 20);
        valueMap.put("C", 15);

        System.out.println("\nValue map: " + valueMap);
        System.out.println("Key with max value: " + findKeyWithMaxValue(valueMap));

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        System.out.println("\nMap1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged map: " + mergeMaps(map1, map2));
    }
}
