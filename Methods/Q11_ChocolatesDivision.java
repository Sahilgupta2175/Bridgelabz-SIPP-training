import java.util.Scanner;

public class Q11_ChocolatesDivision {

    // returns [quotient, remainder]
    public static int[] findRemainderAndQuotient(int chocolates, int children) {
        return new int[] { chocolates / children, chocolates % children };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of chocolates: ");
        int chocolates = sc.nextInt();
        System.out.print("Number of children  : ");
        int children = sc.nextInt();

        int[] qr = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets " + qr[0] + " chocolate(s)");
        System.out.println("Remaining chocolates: " + qr[1]);
        sc.close();
    }
}
