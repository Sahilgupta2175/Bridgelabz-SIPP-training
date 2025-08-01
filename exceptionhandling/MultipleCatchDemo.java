import java.util.*;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        int[] arr = null;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!input.equals("null")) {
            String[] parts = input.split(" ");
            arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++)
                arr[i] = Integer.parseInt(parts[i]);
        }
        int idx = sc.nextInt();
        try {
            System.out.println("Value at index " + idx + ": " + arr[idx]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
        sc.close();
    }
}
