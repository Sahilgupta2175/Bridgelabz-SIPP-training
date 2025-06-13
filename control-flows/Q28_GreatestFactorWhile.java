import java.util.Scanner;
public class Q28_GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), counter = number - 1, greatestFactor = 1;
        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        System.out.println("Greatest factor: " + greatestFactor);
    }
}
