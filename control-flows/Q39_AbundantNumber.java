import java.util.Scanner;
public class Q39_AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                sum += i;
        }
        if (sum > num)
            System.out.println("Abundant Number");
        else
            System.out.println("Not an Abundant Number");
    }
}
