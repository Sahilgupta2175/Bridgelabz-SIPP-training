public class StackUsingArray {
    static int size;
    static int[] arr;

    public StackUsingArray() {
        arr = new int[2];
        size = 0;
    }

    public void add(int value) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = value;
    }

    public static void resize() {
        int newSize = arr.length * 2;
        int[] newArr = new int[newSize];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        for (int i = arr.length; i < newSize; i++) {
            newArr[i] = -1;
        }

        arr = newArr;
    }

    public static void printElement() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);
        stack.add(50);
        stack.add(60);

        System.out.println("Elements in the stack:");
        printElement();
    }
}
