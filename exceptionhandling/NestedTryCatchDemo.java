import java.util.*;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrStr = sc.nextLine().split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++)
            arr[i] = Integer.parseInt(arrStr[i]);
        int idx = sc.nextInt();
        int divisor = sc.nextInt();
        try {
            int val = 0;
            try {
                val = arr[idx];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
                return;
            }
            try {
                int res = val / divisor;
                System.out.println(res);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (Exception e) {
        }
        sc.close();
    }
}
