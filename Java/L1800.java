public class L1800 {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(maxAscendingSum(new int[]{3,6,10,1,8,9,9,8,9}));
    }

    public static int maxAscendingSum(int[] nums) {
        int len = nums.length, result = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            if (i==0 || nums[i-1]<nums[i]) sum+=nums[i];
            else sum=nums[i];
            result = Math.max(result, sum);
        }

        return result;
    }
}
