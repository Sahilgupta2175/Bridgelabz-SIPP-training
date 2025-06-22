public class Q6_DigitCount {
    public static void main(String[] args) {
        int number = 12345, count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        System.out.println("Number of digits: " + count);
    }
}
