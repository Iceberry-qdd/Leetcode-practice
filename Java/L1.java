import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        nums = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        nums = new int[]{3, 3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        nums = new int[]{3, 7, 8, 12, 47, 17, 6, 11, 50, 6, 9, 8};
        System.out.println(Arrays.toString(twoSum(nums, 62)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int nums2 = target - nums[i];
            if (map.containsKey(nums2)) {
                result[1] = i;
                result[0] = map.get(nums2);
                break;
            } else map.put(nums[i], i);
        }
        return result;
    }
}
