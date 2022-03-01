import java.util.Arrays;

public class L977 {
    public static void main(String[] args) {
        //int[] nums = {-4, -1, 0, 3, 10};
        int[] nums = {-10, -9, -8, -6, -2, -1};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int len = nums.length, front = 0, behind = len - 1;
        int[] pow = new int[len];
        while (front <= behind) {
            if (nums[front] * nums[front] > nums[behind] * nums[behind]) {
                pow[--len] = nums[front] * nums[front++];
            } else {
                pow[--len] = nums[behind] * nums[behind--];
            }
        }
        return pow;
    }
}
