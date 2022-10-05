import java.util.*;

public class L1636 {
    public static void main(String[] args) {
        int[] result = frequencySort(new int[]{1, 1, 2, 2, 2, 3});
        System.out.println(Arrays.toString(result));

        result = frequencySort(new int[]{2, 3, 1, 3, 2});
        System.out.println(Arrays.toString(result));
    }

    public static int[] frequencySort(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        list.sort((a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            else return a[1] - b[1];
        });

        int[] result = new int[len];
        int i = 0;
        for (int[] arr : list) {
            int count = arr[1];
            while (count > 0) {
                result[i++] = arr[0];
                count--;
            }
        }

        return result;
    }
}
