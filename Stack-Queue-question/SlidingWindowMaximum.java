import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.print("Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Sliding Window Maximum (k=" + k + "): ");
        for (int max : result) {
            System.out.print(max + " ");
        }
        System.out.println();
    }
}
