import java.util.Scanner;
public class Q32_CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        System.out.println("Digits: " + count);
    }
}
