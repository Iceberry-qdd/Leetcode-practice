import java.util.Arrays;

public class L905 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int[] result = sortArrayByParity(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            } else left++;
        }
        return nums;
    }
}
