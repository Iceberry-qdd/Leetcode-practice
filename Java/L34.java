import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class L34 {

    public static void main(String[] args) {
        int[] nums = {5,5,5,7,7,8,8,10};
        int target = 5;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length;
        int[] loc = {-1, -1};
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                loc[0]=loc[1]=mid;
                for (int i = mid; i < right - 1; i++) {
                    if (nums[i+1] == target) loc[1] = i + 1;
                    else break;
                }
                for (int i = mid; i > 0; i--) {
                    if (nums[i-1] == target) loc[0] = i - 1;
                    else break;
                }
                return loc;
            }
            if (nums[mid] < target) left = mid + 1;
            if (nums[mid] > target) right = mid;
        }
        return loc;
    }

    public static void test(int length, int start, int end, int target) {
        //ArrayList<Integer> nums=new ArrayList<>(length);
        Random random = new Random();
        IntStream ints = random.ints(length, start, end);
        //ints.forEach(nums::add);
        int[] nums = ints.boxed().mapToInt(Integer::intValue).toArray();
        int[] loc = searchRange(nums, target);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(loc));
        System.out.println("\n");
    }
}
