import java.util.Random;

public class Q37_PlayerHeightStats {

    public static int[] generateHeights() {
        Random rand = new Random();
        int[] heights = new int[11];
        for (int i = 0; i < 11; i++)
            heights[i] = 150 + rand.nextInt(101); // 150 to 250
        return heights;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int a : arr)
            s += a;
        return s;
    }

    public static int mean(int[] arr) {
        return sum(arr) / arr.length;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int a : arr)
            if (a < min)
                min = a;
        return min;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int a : arr)
            if (a > max)
                max = a;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights();
        System.out.print("Player Heights (cm): ");
        for (int h : heights)
            System.out.print(h + " ");
        System.out.println("\nShortest: " + min(heights) + " cm");
        System.out.println("Tallest: " + max(heights) + " cm");
        System.out.println("Mean Height: " + mean(heights) + " cm");
    }
}
