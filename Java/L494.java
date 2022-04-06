public class L494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));

        nums = new int[]{1};
        System.out.println(findTargetSumWays(nums, 1));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; i++) sum += nums[i];

        if ((sum + target) % 2 == 1 || sum < Math.abs(target)) return 0;
        int left = (sum + target) / 2;

        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }
}
