package list;

import java.util.*;

public class RotateList {

    public static <T> void rotateLeft(List<T> list, int positions) {
        if (list.isEmpty() || positions <= 0)
            return;

        int size = list.size();
        positions = positions % size;

        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));

        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original list: " + list);
        rotateLeft(list, 2);
        System.out.println("After rotating by 2 positions: " + list);
    }
}
