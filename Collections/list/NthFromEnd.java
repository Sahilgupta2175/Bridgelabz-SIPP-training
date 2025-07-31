package list;

import java.util.*;

public class NthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list.isEmpty() || n <= 0)
            return null;

        int size = list.size();

        if (n > size)
            return null;

        int targetIndex = size - n;

        return list.get(targetIndex);
    }

    public static <T> T findNthFromEndTwoPointers(LinkedList<T> list, int n) {
        if (list.isEmpty() || n <= 0)
            return null;

        List<T> listArray = new ArrayList<>(list);

        if (n > listArray.size())
            return null;

        return listArray.get(listArray.size() - n);
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>(Arrays.asList('A', 'B', 'C', 'D', 'E'));
        System.out.println("List: " + list);
        System.out.println("2nd element from end: " + findNthFromEnd(list, 2));
        System.out.println("2nd element from end (two pointers): " + findNthFromEndTwoPointers(list, 2));
    }
}
