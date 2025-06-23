import java.util.Scanner;

class Q2_MaxHandshakes {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int handshakes = calculateHandshakes(n);
        System.out.println("Maximum handshakes: " + handshakes);
        sc.close();
    }
}
