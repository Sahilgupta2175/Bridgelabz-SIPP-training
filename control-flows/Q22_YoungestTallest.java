import java.util.Scanner;
public class Q22_YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age1 = sc.nextInt(), height1 = sc.nextInt();
        int age2 = sc.nextInt(), height2 = sc.nextInt();
        int age3 = sc.nextInt(), height3 = sc.nextInt();

        String youngest = (age1 <= age2 && age1 <= age3) ? "Amar" : (age2 <= age3 ? "Akbar" : "Anthony");
        String tallest = (height1 >= height2 && height1 >= height3) ? "Amar" : (height2 >= height3 ? "Akbar" : "Anthony");

        System.out.println("Youngest: " + youngest);
        System.out.println("Tallest: " + tallest);
    }
}
