import java.util.Scanner;

class Q4_PositiveNegativeZero {
    public static int checkNumber(int num) {
        if (num < 0)
            return -1;
        else if (num > 0)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int result = checkNumber(num);
        System.out.println("Result: " + result);
        sc.close();
    }
}
