import java.util.Scanner;

public class Q5_MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        int[] table = new int[10];

        for (int i = 0; i < 10; i++) {
            table[i] = num * (i + 1);
            System.out.println(num + " * " + (i + 1) + " = " + table[i]);
        }
        sc.close();
    }
}
