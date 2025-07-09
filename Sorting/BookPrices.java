import java.util.*;

public class BookPrices {
    public static void mergeSort(int[] bookPrices, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(bookPrices, start, mid);
        mergeSort(bookPrices, mid + 1, end);
        merge(bookPrices, start, mid, end);
    }

    public static void merge(int[] bookPrices, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (bookPrices[i] < bookPrices[j]) {
                temp[k] = bookPrices[i];
                i++;
            } else {
                temp[k] = bookPrices[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = bookPrices[i];
            i++;
            k++;
        }

        while (j <= end) {
            temp[k] = bookPrices[j];
            j++;
            k++;
        }

        for (k = 0, i = start; k < temp.length; k++, i++) {
            bookPrices[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total book price number: ");
        int n = sc.nextInt();

        int[] bookPrices = new int[n];

        System.out.println("Enter books price: ");

        for (int i = 0; i < bookPrices.length; i++) {
            bookPrices[i] = sc.nextInt();
        }

        int start = 0;
        int end = bookPrices.length - 1;

        mergeSort(bookPrices, start, end);

        System.out.println("Sorted marks are:");

        System.out.println(Arrays.toString(bookPrices));

        sc.close();
    }
}
