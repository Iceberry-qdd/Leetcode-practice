package C289;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C6041 {
    public static void main(String[] args) {

    }

    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int item : nums[i]) {
                map.merge(item, 1, Integer::sum);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == len) {
                result.add(entry.getKey());
            }
        }

        result.sort((o1, o2) -> o1 - o2);
        return result;
    }
}
