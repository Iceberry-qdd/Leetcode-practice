public class L377 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(combinationSum4(new int[]{9}, 3));
    }

    public static int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target+1];// dp[i]表示总和为i的元素的排列个数为dp[i]个
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < len; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
