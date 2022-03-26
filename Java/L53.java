public class L53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

        nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));

        nums = new int[]{-1, -1, -1, -1};
        System.out.println(maxSubArray(nums));

        nums = new int[]{1};
        System.out.println(maxSubArray(nums));

        nums = new int[]{8,-19,5,-4,20};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0, result = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (result < sum) result = sum;

            if (sum < 0) sum = 0;
        }
        return result;
    }
}
