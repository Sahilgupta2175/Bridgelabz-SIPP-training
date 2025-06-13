import java.util.Scanner;
public class Q5_SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0, num;
        while (true) {
            num = sc.nextDouble();
            if (num == 0)
                break;
            total += num;
        }
        System.out.println("Total: " + total);
    }
}
