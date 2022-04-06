import java.util.*;

public class L491 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> result = findSubsequences(nums);
        System.out.println(result);

        nums=new int[]{4,4,3,2,1};
        result=findSubsequences(nums);
        System.out.println(result);

        nums=new int[]{100,90,80,70,60,50,60,70,80,90,100};
        result=findSubsequences(nums);
        System.out.println(result);

    }

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        result.clear();
        backTracing(nums, 0, Integer.MIN_VALUE);
        return result;
    }

    static List<Integer> item = new ArrayList<>();

    public static void backTracing(int[] nums, int startIndex, int lastElem) {
        int len = nums.length;
        if (startIndex > len) return;
        if (item.size() >= 2) {
            result.add(new ArrayList<>(item));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < len; i++) {
            if (set.contains(nums[i])) continue;
            if (nums[i] >= lastElem) {
                item.add(nums[i]);
                set.add(nums[i]);
            }else continue;

            backTracing(nums, i + 1, nums[i]);
            item.remove(item.size() - 1);
        }
    }
}
