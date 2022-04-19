import java.util.HashSet;
import java.util.Set;

public class L41 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4, 3};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{0};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{1};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{2};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{2, 1};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{1, 2, 6, 3, 5, 4};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return len + 1;
    }
}
