import java.util.Scanner;

public class Q6_YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age1 = sc.nextInt(), height1 = sc.nextInt();
        int age2 = sc.nextInt(), height2 = sc.nextInt();
        int age3 = sc.nextInt(), height3 = sc.nextInt();

        // Youngest
        if (age1 <= age2 && age1 <= age3) {
            System.out.println("Amar is the youngest.");
        } else if (age2 <= age1 && age2 <= age3) {
            System.out.println("Akbar is the youngest.");
        } else {
            System.out.println("Anthony is the youngest.");
        }

        // Tallest
        if (height1 >= height2 && height1 >= height3) {
            System.out.println("Amar is the tallest.");
        } else if (height2 >= height1 && height2 >= height3) {
            System.out.println("Akbar is the tallest.");
        } else {
            System.out.println("Anthony is the tallest.");
        }
        sc.close();
    }
}
