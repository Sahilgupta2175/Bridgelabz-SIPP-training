import java.util.Scanner;

public class Q1_PosNegZero {
    public static void main(String[] args) {
        int[] nums = new int[5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = sc.nextInt();

            if (nums[i] > 0) {
                System.out.println(nums[i] + " is Positive and " + (nums[i] % 2 == 0 ? "Even" : "Odd"));
            } else if (nums[i] < 0) {
                System.out.println(nums[i] + " is Negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (nums[0] == nums[4]) {
            System.out.println("First and Last elements are Equal");
        } else if (nums[0] > nums[4]) {
            System.out.println("First element is Greater");
        } else {
            System.out.println("Last element is Greater");
        }
        sc.close();
    }
}
