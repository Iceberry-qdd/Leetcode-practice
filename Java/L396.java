public class L396 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(nums));

        nums = new int[]{100};
        System.out.println(maxRotateFunction(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(maxRotateFunction(nums));
    }

    public static int maxRotateFunction(int[] nums) {
        int len = nums.length, sum = 0;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += nums[i] * i;
            sum += nums[i];
        }

        int result = F;
        for (int i = 0; i < len - 1; i++) {
            F = sum - len * nums[len - i - 1] + F;
            result = Math.max(result, F);
        }

        return result;
    }
}
