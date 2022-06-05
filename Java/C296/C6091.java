package C296;

import java.util.Arrays;

public class L6091 {
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{3, 6, 1, 2, 5}, 2));
        System.out.println(partitionArray(new int[]{2, 2, 4, 5}, 0));
    }

    public static int partitionArray(int[] nums, int k) {
        int len = nums.length, result = 0;
        Arrays.sort(nums);
        for (int left = 0, right = 0; right < len && left < len; left++) {
            while (right < len && nums[right] - nums[left] <= k) right++;
            right--;
            if (right >= len) right = len - 1;
            if (nums[right] - nums[left] <= k) {
                result++;
                left = right;
                right++;
            }
        }
        return result;
    }
}
