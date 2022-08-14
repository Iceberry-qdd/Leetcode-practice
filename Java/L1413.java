public class L1413 {
    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3,2,-3,4,2}));
    }

    public static int minStartValue(int[] nums) {
        int len = nums.length, minPrefixSum = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            minPrefixSum = Math.min(minPrefixSum, sum);
        }
        return 1 - minPrefixSum;
    }
}
