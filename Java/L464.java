import java.util.Arrays;

public class L464 {
    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1, 2, 3}));
        System.out.println(minMoves2(new int[]{1, 10, 2, 9}));
    }

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, midNum = nums[len / 2], result = 0;
        for (int i = 0; i < len; i++) {
            result += Math.abs(nums[i] - midNum);
        }
        return result;
    }
}
