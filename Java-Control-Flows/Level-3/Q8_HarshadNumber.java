public class Q8_HarshadNumber {
    public static void main(String[] args) {
        int number = 18, original = number, sum = 0;
        while (original != 0) {
            sum += original % 10;
            original /= 10;
        }
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is not a Harshad Number");
        }
    }
}
