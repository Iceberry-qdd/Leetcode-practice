import java.util.Arrays;

public class L1005 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3};
        System.out.println(largestSumAfterKNegations(nums, 1));

        nums = new int[]{3, -1, 0, 2};
        System.out.println(largestSumAfterKNegations(nums, 3));

        nums = new int[]{2, -3, -1, 5, -4};
        System.out.println(largestSumAfterKNegations(nums, 2));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue)
                .toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (k > 0 && nums[i] <= 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }
}
