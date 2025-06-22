import java.util.Scanner;

public class Q10_GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int counter = number - 1;
        int greatestFactor = 1;
        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        System.out.println("Greatest factor (excluding itself): " + greatestFactor);
        sc.close();
    }
}
