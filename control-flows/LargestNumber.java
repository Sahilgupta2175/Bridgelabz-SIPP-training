import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int number1 = input.nextInt();
        System.out.println("Enter the second number: ");
        int number2 = input.nextInt();
        System.out.println("Enter the third number: ");
        int number3 = input.nextInt();

        boolean isFirstNumber = (number1 >= number2) && (number1 >= number3);
        boolean isSecondNumber = (number2 >= number1) && (number2 >= number3);
        boolean isThirdNumber = (number3 >= number1) && (number3 >= number2);

        System.out.println("Is the first number the largest? " + isFirstNumber);
        System.out.println("Is the second number the largest? " + isSecondNumber);
        System.out.println("Is the third number the largest? " + isThirdNumber);

        input.close();
    }
}
