import java.util.*;

public class StudentAges {
    public static void countingSort(int[] ages) {
        int maxAge = 18;
        int minAge = 10;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - minAge]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of students:");
        int n = sc.nextInt();

        int[] ages = new int[n];

        System.out.println("Enter the student ages (10-18):");
        for (int i = 0; i < ages.length; i++) {
            ages[i] = sc.nextInt();
        }

        countingSort(ages);

        System.out.println("Sorted student ages:");
        System.out.println(Arrays.toString(ages));

        sc.close();
    }
}
