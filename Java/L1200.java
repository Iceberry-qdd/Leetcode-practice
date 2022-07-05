import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1200 {
    public static void main(String[] args) {
        List<List<Integer>> result = minimumAbsDifference(new int[]{4, 2, 1, 3});
        System.out.println(result);
        result = minimumAbsDifference(new int[]{1, 3, 6, 10, 15});
        System.out.println(result);
        result = minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27});
        System.out.println(result);
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length, minSub = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>(len);
        for (int i = 0; i < len - 1; i++) {
            int curMinSub = arr[i + 1] - arr[i];
            if (curMinSub > minSub) continue;
            if (curMinSub < minSub) {
                result.clear();
            }
            List<Integer> pair = new ArrayList<>(2);
            pair.add(arr[i]);
            pair.add(arr[i + 1]);
            result.add(pair);
            minSub = curMinSub;
        }
        return result;
    }
}
