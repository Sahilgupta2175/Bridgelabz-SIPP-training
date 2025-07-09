import java.util.*;

public class StudentMarks {
    public static void bubbleSort(int[] marks) {
        for (int i = 0; i < marks.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[i] > marks[j]) {
                    int temp = marks[i];
                    marks[i] = marks[j];
                    marks[j] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total marks number:");
        int n = sc.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter the marks:");

        for (int i = 0; i < marks.length; i++) {
            marks[i] = sc.nextInt();
        }

        bubbleSort(marks);

        System.out.println("Sorted marks are:");
        
        System.out.println(Arrays.toString(marks));

        sc.close();
    }
}