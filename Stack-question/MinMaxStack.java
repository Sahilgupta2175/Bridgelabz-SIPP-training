import java.util.EmptyStackException;

public class MinMaxStack {
    private int[] arr;
    private int[] minStack;
    private int[] maxStack;
    private int top;
    private int minTop;
    private int maxTop;
    private int maxSize;

    public MinMaxStack(int capacity) {
        maxSize = capacity;
        arr = new int[maxSize];
        minStack = new int[maxSize];
        maxStack = new int[maxSize];
        top = -1;
        minTop = -1;
        maxTop = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack overflow");
        }

        arr[++top] = value;

        if (minTop == -1 || value <= minStack[minTop]) {
            minStack[++minTop] = value;
        }

        if (maxTop == -1 || value >= maxStack[maxTop]) {
            maxStack[++maxTop] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int value = arr[top--];

        if (value == minStack[minTop]) {
            minTop--;
        }

        if (value == maxStack[maxTop]) {
            maxTop--;
        }

        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public int getMin() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack[minTop];
    }

    public int getMax() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack[maxTop];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack(5);

        stack.push(10);
        stack.push(5);
        stack.push(20);
        stack.push(3);

        System.out.println("Min: " + stack.getMin());
        System.out.println("Max: " + stack.getMax());
        System.out.println("Popped: " + stack.pop());
        System.out.println("New Min: " + stack.getMin());
        System.out.println("New Max: " + stack.getMax());
    }
}
