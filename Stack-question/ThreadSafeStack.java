import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadSafeStack {
    private ConcurrentLinkedDeque<Integer> stack;

    public ThreadSafeStack() {
        stack = new ConcurrentLinkedDeque<>();
    }

    public void push(int value) {
        stack.addFirst(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.removeFirst();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peekFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        ThreadSafeStack stack = new ThreadSafeStack();

        Runnable producer = () -> {
            for (int i = 1; i <= 5; i++) {
                stack.push(i * 10);
                System.out.println("Pushed: " + (i * 10));
            }
        };

        Runnable consumer = () -> {
            while (!stack.isEmpty()) {
                try {
                    int value = stack.pop();
                    System.out.println("Popped: " + value);
                } catch (Exception e) {
                    break;
                }
            }
        };

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
