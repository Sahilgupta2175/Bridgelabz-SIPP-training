package queue;

public class CircularBuffer<T> {
    private Object[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void insert(T item) {
        buffer[tail] = item;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity;
        }
    }

    @SuppressWarnings("unchecked")
    public T remove() {
        if (size == 0) {
            throw new RuntimeException("Buffer is empty");
        }

        T item = (T) buffer[head];
        buffer[head] = null;
        head = (head + 1) % capacity;
        size--;

        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            sb.append(buffer[index]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.println("After inserting 1, 2, 3: " + buffer);

        buffer.insert(4);
        System.out.println("After inserting 4 (overwrites oldest): " + buffer);

        buffer.insert(5);
        System.out.println("After inserting 5: " + buffer);
    }
}
