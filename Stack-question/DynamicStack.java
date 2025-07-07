import java.util.ArrayDeque;
import java.util.Deque;

public class DynamicStack {
    private Deque<Integer> stack;

    public DynamicStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack();

        for (int i = 1; i <= 1000; i++) {
            stack.push(i);
        }

        System.out.println("Size after pushing 1000 elements: " + stack.size());
        System.out.println("Top element: " + stack.peek());

        for (int i = 0; i < 500; i++) {
            stack.pop();
        }

        System.out.println("Size after popping 500 elements: " + stack.size());
        System.out.println("New top element: " + stack.peek());
    }
}
