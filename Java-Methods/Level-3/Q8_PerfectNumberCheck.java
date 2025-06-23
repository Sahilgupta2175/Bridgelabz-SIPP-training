public class Q8_PerfectNumberCheck {
    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println("Is 28 Perfect? " + isPerfect(28));
    }
}
