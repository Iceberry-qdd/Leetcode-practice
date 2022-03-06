import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18 {
    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;
        if (len < 4) return result;

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            //if (nums[i] > target) return result;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < len; j++) {

                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = len - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
