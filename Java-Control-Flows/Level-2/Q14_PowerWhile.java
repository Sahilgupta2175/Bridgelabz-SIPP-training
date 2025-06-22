import java.util.Scanner;

public class Q14_PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt(), exponent = sc.nextInt();
        int result = 1, counter = 0;
        while (counter < exponent) {
            result *= base;
            counter++;
        }
        System.out.println("Power: " + result);
        sc.close();
    }
}
