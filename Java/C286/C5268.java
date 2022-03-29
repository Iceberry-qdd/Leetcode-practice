package C286;

import java.util.*;

public class C5268 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}, nums2 = {2, 4, 6};
        List<List<Integer>> result = findDifference(nums1, nums2);
        System.out.println(result);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();

        for (int j : nums1) list1.add(j);
        for (int j : nums2) list2.add(j);

        Set<Integer> list1Backup = Set.copyOf(list1);
        list1.removeAll(list2);
        list2.removeAll(list1Backup);

        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(list1.toArray(new Integer[0])));
        result.add(Arrays.asList(list2.toArray(new Integer[0])));

        return result;
    }
}
