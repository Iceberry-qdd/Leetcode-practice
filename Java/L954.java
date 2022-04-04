import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L954 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 6};
        System.out.println(canReorderDoubled(arr));

        arr = new int[]{2, 1, 2, 6};
        System.out.println(canReorderDoubled(arr));

        arr = new int[]{4, -2, 2, -4};
        System.out.println(canReorderDoubled(arr));

        arr = new int[]{-2, 1};
        System.out.println(canReorderDoubled(arr));

        arr = new int[]{2, 4, 0, 0, 8, 1};
        System.out.println(canReorderDoubled(arr));

        arr = new int[]{-33, 0};
        System.out.println(canReorderDoubled(arr));

        arr = new int[]{4, -4, -1, -6, 8, -2, -4, -2, 4, 8, -3, -3, -2, -6};
        System.out.println(canReorderDoubled(arr));
    }

    public static boolean canReorderDoubled(int[] arr) {
        int len = arr.length;
        if (len == 0) return false;
        arr = Arrays.stream(arr)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o1) - Math.abs(o2))
                .mapToInt(Integer::intValue)
                .toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }

        int pairCount = 0;
        for (int i = 0; i < len && pairCount < len / 2; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) == 0) continue;
            if (!map.containsKey(2 * arr[i])) break;

            if (map.get(2 * arr[i]) != 0) {
                map.merge(2 * arr[i], -1, Integer::sum);
            } else continue;

            if (map.get(arr[i]) != 0) {
                map.merge(arr[i], -1, Integer::sum);
                pairCount++;
            } else {
                map.merge(2 * arr[i], 1, Integer::sum);
            }
        }
        return pairCount == len / 2;
    }
}
