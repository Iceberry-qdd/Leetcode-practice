import java.util.*;

public class L350 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //int len1=nums1.length,len2=nums2.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int val : nums1)
            if (map1.containsKey(val)) {
                map1.put(val, map1.get(val) + 1);
            } else map1.put(val, 1);

        for (int val : nums2)
            if (map2.containsKey(val)) {
                map2.put(val, map2.get(val) + 1);
            } else map2.put(val, 1);

        for (Integer key : map2.keySet())
            if (map1.containsKey(key)) {
                int i = Math.min(map1.get(key), map2.get(key));
                while (i-- > 0) result.add(key);
            }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
