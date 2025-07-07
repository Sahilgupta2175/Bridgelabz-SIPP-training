import java.util.Stack;

public class RecursiveStackOperations {
    private Stack<Integer> stack;

    public RecursiveStackOperations() {
        stack = new Stack<>();
    }

    public void insertAtBottom(int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(value);
        stack.push(temp);
    }

    public void reverse() {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverse();
            insertAtBottom(temp);
        }
    }

    public void sortStack() {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack();
            sortedInsert(temp);
        }
    }

    private void sortedInsert(int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        sortedInsert(value);
        stack.push(temp);
    }

    public void push(int value) {
        stack.push(value);
    }

    public void printStack() {
        System.out.println("Stack: " + stack);
    }

    public static void main(String[] args) {
        RecursiveStackOperations rso = new RecursiveStackOperations();

        rso.push(30);
        rso.push(10);
        rso.push(40);
        rso.push(20);

        System.out.println("Original stack:");
        rso.printStack();

        rso.reverse();
        System.out.println("After reversing:");
        rso.printStack();

        rso.sortStack();
        System.out.println("After sorting:");
        rso.printStack();

        rso.insertAtBottom(5);
        System.out.println("After inserting 5 at bottom:");
        rso.printStack();
    }
}
