import java.util.Arrays;

public class L1470 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] result = new int[len];
        for (int left = 0, right = len / 2, i = 0; left < len / 2; left++, right++) {
            result[i++] = nums[left];
            result[i++] = nums[right];
        }
        return result;
    }
}
