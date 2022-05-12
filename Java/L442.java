import java.util.ArrayList;
import java.util.List;

public class L442 {
    public static void main(String[] args) {
        List<Integer> result = findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(result);

        result = findDuplicates(new int[]{1, 1, 2});
        System.out.println(result);

        result = findDuplicates(new int[]{1});
        System.out.println(result);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) result.add(Math.abs(nums[i]));
            else nums[index] *= -1;
        }
        return result;
    }
}
