package C288;

import java.math.BigDecimal;
import java.util.PriorityQueue;

public class C6039 {
    public static void main(String[] args) {
        int[] nums = {0, 4};
        System.out.println(maximumProduct(nums, 5));

        nums = new int[]{6, 3, 3, 2};
        System.out.println(maximumProduct(nums, 2));

        nums = new int[]{24,5,64,53,26,38};
        System.out.println(maximumProduct(nums, 54));
    }

    public static int maximumProduct(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(len, (o1, o2) -> o1 - o2);
        for (int i = 0; i < len; i++) {
            queue.add(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            Integer minNum = queue.poll();
            queue.add(minNum + 1);

        }
        long multiplication = 1;
        for (Integer num : queue) {
            multiplication *= num;
            multiplication%=(1e9 + 7);
        }
        return (int) multiplication;
    }
}
