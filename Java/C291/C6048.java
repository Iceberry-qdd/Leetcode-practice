package C291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C6048 {
    public static void main(String[] args) {
        System.out.println(minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));
        System.out.println(minimumCardPickup(new int[]{1, 0, 5, 3}));
    }

    public static int minimumCardPickup(int[] cards) {
        int len = cards.length, result = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>(len);

        for (int i = 0; i < len; i++) {
            if (!map.containsKey(cards[i])) {
                map.put(cards[i], i);
            } else {
                result = Math.min(result, i - map.get(cards[i]) + 1);
                map.put(cards[i], i);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
