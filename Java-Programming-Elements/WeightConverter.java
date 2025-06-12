import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        double pounds = input.nextDouble();
        double kg = pounds / 2.2;
        System.out.printf("The weight of the person in pounds is %.2f and in kg is %.2f%n",
                         pounds, kg);
        input.close();
    }
}