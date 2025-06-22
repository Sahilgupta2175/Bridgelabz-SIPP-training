import java.util.Scanner;

public class Q2_FirstIsSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
        System.out.println("Is the first number the smallest? " + (n1 < n2 && n1 < n3));
        sc.close();
    }
}
