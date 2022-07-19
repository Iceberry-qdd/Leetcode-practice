package C302;

import java.util.Arrays;

public class C6164 {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
    }

    public static int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, result = -1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (num > 0) {
                arr[i] += num % 10;
                num = num / 10;
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (i != j && arr[i] == arr[j]) {
                    result = Math.max(result, nums[i] + nums[j]);
                    break;
                }
            }
        }
        return result;
    }
}
