public class Q5_ArmstrongNumber {
    public static void main(String[] args) {
        int number = 153, original = number, sum = 0;
        while (original != 0) {
            int digit = original % 10;
            sum += digit * digit * digit;
            original /= 10;
        }
        if (sum == number) {
            System.out.println(number + " is an Armstrong Number");
        } else {
            System.out.println(number + " is not an Armstrong Number");
        }
    }
}
