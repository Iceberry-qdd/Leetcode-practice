public class L376 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        int result = wiggleMaxLength(nums);
        System.out.println(result);

        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(wiggleMaxLength(new int[]{0, 0}));
        System.out.println(wiggleMaxLength(new int[]{0, 0, 0}));
        System.out.println(wiggleMaxLength(new int[]{0, 0, 0, 0, 0}));
        System.out.println(wiggleMaxLength(new int[]{0, 0, 0, 0, 0, 0, 0}));
        System.out.println(wiggleMaxLength(new int[]{3, 3, 3, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1, 1, 7, 4, 9, 2, 5}));

    }

    public static int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int count = 1, lastDiff =0;
        for (int i = 0; i < len-1; i++) {
            if (nums[i+1] - nums[i] < 0 && lastDiff >= 0){
                count++;
            }
            else if (nums[i+1] - nums[i] > 0 && lastDiff <= 0){
                count++;
                lastDiff = nums[i+1] - nums[i];
            }
        }
        return count;
    }
}
