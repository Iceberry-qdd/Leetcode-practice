package C299;

public class C5229 {
    public static void main(String[] args) {
        System.out.println(maximumsSplicedArray(new int[]{60, 60, 60}, new int[]{10, 90, 10}));
    }

    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int len = nums1.length, sum1 = 0, sum2 = 0;
        int[] diff1 = new int[len], diff2 = new int[len];
        for (int i = 0; i < len; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            diff1[i] = nums1[i] - nums2[i];
            diff2[i] = nums2[i] - nums1[i];
        }
        return Math.max(sum1 + maxSubArr(diff2), sum2 + maxSubArr(diff1));
    }

    public static int maxSubArr(int[] nums) {
        int len = nums.length, result = nums[0], cur = nums[0];
        for (int i = 1; i < len; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            result = Math.max(result, cur);
        }
        return result;
    }
}
