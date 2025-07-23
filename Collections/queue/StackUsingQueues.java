package queue;

import java.util.*;

public class StackUsingQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(T item) {
        queue2.offer(item);

        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public T pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.poll();
    }

    public T top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.top());
    }
}
