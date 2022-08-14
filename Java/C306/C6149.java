package C306;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class C6149 {
    public static void main(String[] args) {
        System.out.println(edgeScore(new int[]{1, 0, 0, 0, 0, 7, 7, 5}));
    }

    public static int edgeScore(int[] edges) {
        Map<Integer, BigInteger> map = new HashMap<>();
        int len = edges.length, result = -1;
        for (int i = 0; i < len; i++) {
            map.merge(edges[i], BigInteger.valueOf(i), BigInteger::add);
        }

        BigInteger maxValue = BigInteger.valueOf(-1);
        for (Integer key : map.keySet()) {
            if (map.get(key).compareTo(maxValue) > 0) {
                maxValue = map.get(key);
                result = key;
            } else if (map.get(key).compareTo(maxValue) == 0) {
                result = Math.min(result, key);
            }
        }
        return result;
    }
}
