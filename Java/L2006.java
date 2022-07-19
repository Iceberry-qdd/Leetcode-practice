import java.util.HashMap;
import java.util.Map;

public class L2006 {
    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));
    }

    public static int countKDifference(int[] nums, int k) {
        int len = nums.length, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i] + k)) {
                result += map.get(nums[i] + k);
            } else if (map.containsKey(nums[i] - k)) {
                result += map.get(nums[i] - k);
            }
        }
        return result / 2;
    }
}
