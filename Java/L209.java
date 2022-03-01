public class L209 {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int target = 4;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, len = nums.length, sum = 0, minLen = len + 1;
        for (int right = 0; right < len; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(right - left + 1, minLen);
                left++;
                sum -= nums[left - 1];
            }
        }
        return minLen == len + 1 ? 0 : minLen;
    }
}
