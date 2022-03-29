package C286;

public class C5236 {
    public static void main(String[] args) {
        //int[] nums = {1, 6, 0, 9, 8, 8, 4, 1, 7, 1, 1, 8, 9, 1, 9, 1, 2, 3, 7, 6, 6, 8, 7, 5, 9, 7, 3, 0, 4, 9, 1, 8, 3, 3, 2, 4, 2, 6, 2, 8, 9, 2, 8, 4, 0, 1, 0, 9, 9, 5};
        int[] nums = {1, 1, 2, 2, 3, 3};
        long startTime = System.currentTimeMillis();
        int result = minDeletion(nums);
        long endTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.printf("执行用时：%dms", endTime - startTime);
    }

    public static int minDeletion(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int size = 1, result = 0, lastNum = nums[0];
        for (int i = 1; i < len; i++) {
            if (size % 2 != 0 && nums[i] == lastNum) {
                result++;
            } else {
                lastNum = nums[i];
                size++;
            }
        }
        if (size % 2 != 0) result++;
        return result;
    }

}
