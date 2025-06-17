import java.util.Arrays;
import java.util.Random;

public class Q17_RandomStats {

    public static int[] generate4DigitRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + rand.nextInt(9000);
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) {
            sum += num;
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }
        return new double[] { (double) sum / numbers.length, min, max };
    }

    public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);
        System.out.println("Random Numbers: " + Arrays.toString(arr));
        double[] stats = findAverageMinMax(arr);
        System.out.printf("Average: %.2f\nMin: %.0f\nMax: %.0f\n", stats[0], stats[1], stats[2]);
    }
}
