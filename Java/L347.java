import java.util.*;

public class L347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
        nums = new int[]{1};
        k = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int lenN = nums.length;
        Map<Integer, Integer> map = new HashMap<>(lenN);
        for (int i = 0; i < lenN; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> map.get(o1) - map.get(o2)
        );

        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.remove();
                queue.add(key);
            }
        }

        int lenQ = queue.size();
        int[] result = new int[lenQ];

        for (int i = 0; i < lenQ; i++) {
            result[i] = queue.remove();
        }

        return result;
    }
}
