import java.util.Arrays;

public class L283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length, fastIndex = 0, slowIndex = 0;
        while (fastIndex < length) {
            if (nums[fastIndex] == 0) {
                fastIndex++;
                continue;
            }
            nums[slowIndex++] = nums[fastIndex++];
        }
        Arrays.fill(nums, slowIndex, length, 0);
    }
}
