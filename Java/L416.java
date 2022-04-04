public class L416 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; i++) sum += nums[i];

        if (sum % 2 != 0) return false;
        int[] dp = new int[sum / 2 + 1];

        for (int i = 0; i < len; i++) {// 遍历物品
            for (int j = sum / 2; j >= nums[i]; j--) {// 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[sum / 2] == sum / 2;
    }
}
