import java.util.EmptyStackException;

public class FixedSizeStack {
    private int[] arr;
    private int top;
    private int maxSize;

    public FixedSizeStack(int capacity) {
        maxSize = capacity;
        arr = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack overflow");
        }
        arr[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        FixedSizeStack stack = new FixedSizeStack(3);

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);

            System.out.println("Popped: " + stack.pop());
            System.out.println("Peek: " + stack.peek());
            System.out.println("Size: " + stack.size());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
