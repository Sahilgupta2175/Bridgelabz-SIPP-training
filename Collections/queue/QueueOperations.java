package queue;

import java.util.*;

public class QueueOperations {

    public static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed queue: " + queue);

        System.out.println("\nFirst 5 binary numbers: " + generateBinaryNumbers(5));
    }
}
