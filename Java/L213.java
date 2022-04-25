public class L213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{1, 2, 3}));
        System.out.println(rob(new int[]{0, 0}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int result1 = robRange(nums, 1, len - 1);
        int result2 = robRange(nums, 0, len - 2);
        return Math.max(result1, result2);
    }

    public static int robRange(int[] nums, int startIndex, int endIndex) {
        if (startIndex == endIndex) return nums[startIndex];
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[startIndex] = nums[startIndex];
        dp[startIndex + 1] = Math.max(dp[startIndex], nums[startIndex + 1]);
        for (int i = startIndex + 2; i <= endIndex; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[endIndex];
    }
}
