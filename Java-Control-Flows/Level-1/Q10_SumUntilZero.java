import java.util.Scanner;

public class Q10_SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0, input;
        do {
            input = sc.nextDouble();
            total += input;
        } while (input != 0);
        System.out.println("Total: " + total);
        sc.close();
    }
}
