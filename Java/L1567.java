public class L1567 {
    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(getMaxLen((new int[]{0, 1, -2, -3, -4})));
        System.out.println(getMaxLen(new int[]{-1, -2, -3, 0, 1}));
    }

    public static int getMaxLen(int[] nums) {
        int len = nums.length, pCount = 0, nCount = 0, result = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                pCount = 0;
                nCount = 0;
            } else if (nums[i] > 0) {
                pCount++;
                if (nCount > 0) nCount++;
                result = Math.max(result, pCount);
            } else {
                int temp = pCount;
                pCount = nCount;
                nCount = temp;
                nCount++;
                if (pCount > 0) pCount++;
                result = Math.max(result, pCount);
            }
        }
        return result;
    }
}
