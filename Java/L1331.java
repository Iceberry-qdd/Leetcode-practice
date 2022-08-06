import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1331 {
    public static void main(String[] args) {
        int[] result = arrayRankTransform(new int[]{40, 10, 20, 30});
        System.out.println(Arrays.toString(result));

        result = arrayRankTransform(new int[]{100, 100, 100});
        System.out.println(Arrays.toString(result));

        result = arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12});
        System.out.println(Arrays.toString(result));
    }

    public static int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] arrBackup = Arrays.copyOfRange(arr, 0, len);
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0, rank = 1; i < len; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], rank++);
            }
        }

        for (int i = 0; i < len; i++) {
            arr[i] = map.get(arrBackup[i]);
        }
        return arr;
    }
}
