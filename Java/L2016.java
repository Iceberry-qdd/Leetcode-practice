public class L2016 {
    public static void main(String[] args) {
        int[] nums = {1,5,2,10};
        System.out.println(maximumDifference(nums));
    }

    public static int maximumDifference(int[] nums) {
        int length = nums.length;
        int maximum = -1;
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++)
                if (i < j && nums[i] < nums[j]) {
                    int value = nums[j] - nums[i];
                    maximum = Math.max(maximum, value);
                }
        return maximum;
    }
}
