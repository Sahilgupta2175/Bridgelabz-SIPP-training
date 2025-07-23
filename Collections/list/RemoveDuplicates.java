package list;

import java.util.*;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();

        for (T element : list) {
            if (seen.add(element)) {
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> result = removeDuplicatesPreserveOrder(list);
        System.out.println("Input: " + list);
        System.out.println("Output: " + result);
    }
}
