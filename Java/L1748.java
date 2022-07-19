import java.util.HashMap;
import java.util.Map;

public class L1748 {
    public static void main(String[] args) {

    }

    public static int sumOfUnique(int[] nums) {
        int len = nums.length, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result += entry.getKey();
            }
        }
        return result;
    }
}
