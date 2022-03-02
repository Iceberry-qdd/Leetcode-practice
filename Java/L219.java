import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L219 {
    public static void main(String[] args) {
        //int[] nums={1,2,3,1};
        //int[] nums={1,0,1,1};
        //int[] nums = {1, 2, 3, 1, 2, 3};
        int[] nums={1,2,3,2,1,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length, i = 0, lastIndex = -1, minLen = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < len; j++) {
            if (map.containsKey(nums[j])) lastIndex = map.get(nums[j]);
            map.put(nums[j], j);
            if (i == j) continue;
            if (lastIndex == -1 || lastIndex >= j || map.get(nums[j]) <= i) continue;
            i = lastIndex;
            minLen = Math.min(minLen, j - i);
            if (minLen <= k) return true;
        }
        return false;
    }
    /*
public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for (int i=0; i<nums.length; ++i){
        if (i > k) set.remove(nums[i-k-1]);
        if (set.contains(nums[i])) return true;
        set.add(nums[i]);
    }
    return false;
}

     */
}
