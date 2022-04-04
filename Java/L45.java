public class L45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));

        nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(jump(nums));

        nums = new int[]{3, 1, 2, 1, 2, 4};
        System.out.println(jump(nums));

        nums = new int[]{2, 0, 1, 1, 2, 1};
        System.out.println(jump(nums));

        nums = new int[]{3, 1, 2, 1, 2, 1, 2, 1};
        System.out.println(jump(nums));

        nums = new int[]{1};
        System.out.println(jump(nums));

        nums = new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int result = 0, lastMaxRange = 0, curRange = 0;
        for (int i = 0; i < len - 1; i++) {
            curRange = Math.max(curRange, nums[i] + i);
            if (i == lastMaxRange) {
                lastMaxRange = curRange;
                result++;
            }
        }
        return result;
    }
}
