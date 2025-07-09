import java.util.*;

public class ProductPrices {
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of products:");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter the product prices:");
        for (int i = 0; i < prices.length; i++) {
            prices[i] = sc.nextInt();
        }

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted product prices:");
        System.out.println(Arrays.toString(prices));

        sc.close();
    }
}
