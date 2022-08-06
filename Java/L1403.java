import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1403 {
    public static void main(String[] args) {
        System.out.println(minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(minSubsequence(new int[]{4, 4, 7, 6, 7}));
    }

    public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        int reverseSum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            reverseSum += nums[i];
            result.add(nums[i]);
            if (sum - reverseSum < reverseSum) {
                break;
            }
        }
        return result;
    }
}
