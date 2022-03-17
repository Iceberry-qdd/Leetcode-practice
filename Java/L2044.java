public class L2044 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5};

        long startTime = System.currentTimeMillis();
        int result = countMaxOrSubsets(nums);
        long endTime = System.currentTimeMillis();

        System.out.println(result);
        System.out.printf("执行耗时：%dms\n", endTime - startTime);
    }

    public static int countMaxOrSubsets(int[] nums) {
        int len = nums.length, result = 1;
        int maxValue = 0;
        for (int num : nums) {
            maxValue |= num;
        }

        for (int i = 0; i < (1 << len); i++) {
            int orValue = 0;
            for (int j = 0; j < len; j++) {
                if (((i >> j) & 1) == 1) {
                    orValue |= nums[j];
                }
            }
            if (orValue == maxValue) result++;
        }
        return result;
    }
}
