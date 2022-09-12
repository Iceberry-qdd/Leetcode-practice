package C310;

import java.util.Map;
import java.util.TreeMap;

public class C6167 {
    public static void main(String[] args) {
        System.out.println(mostFrequentEven(new int[]{8154, 9139, 8194, 3346, 5450, 9190, 133, 8239, 4606, 8671, 8412, 6290}));
    }

    public static int mostFrequentEven(int[] nums) {
        int result = -1;
        Map<Integer, Integer> map = new TreeMap<>((m1, m2) -> m1 - m2);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) continue;
            map.merge(nums[i], 1, Integer::sum);
        }

        int maxVal = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key) > maxVal) {
                maxVal = map.get(key);
                result = key;
            }
        }
        return result;
    }
}
