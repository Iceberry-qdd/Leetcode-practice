import java.util.*;

public class L349 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        nums1 = new int[]{};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        nums1 = new int[]{9, 4, 9, 8, 4};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int j : nums1) set.add(j);
        for (int j : nums2)
            if (set.contains(j) && !result.contains(j))
                result.add(j);
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
