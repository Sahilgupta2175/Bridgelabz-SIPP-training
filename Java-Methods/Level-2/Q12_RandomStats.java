class Q12_RandomStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int) (Math.random() * 9000); // 1000–9999
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) {
            sum += num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        double avg = sum / (double) numbers.length;
        return new double[] { avg, min, max };
    }

    public static void main(String[] args) {
        int[] numbers = generate4DigitRandomArray(5);
        System.out.print("Numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        double[] result = findAverageMinMax(numbers);
        System.out.printf("Average: %.2f\nMin: %.0f\nMax: %.0f\n", result[0], result[1], result[2]);
    }
}
