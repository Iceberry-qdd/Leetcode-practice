public class L908 {
    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[]{1}, 0));
        System.out.println(smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(smallestRangeI(new int[]{1, 3, 6}, 3));
    }

    public static int smallestRangeI(int[] nums, int k) {
        int len = nums.length;
        int minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            minNum = Math.min(minNum, nums[i]);
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (maxNum - minNum > 2 * k){
            return maxNum - minNum - 2 * k;
        } else return 0;
    }
}
