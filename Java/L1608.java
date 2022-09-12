import java.util.Arrays;

public class L1608 {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3, 5}));
    }

    public static int specialArray(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    count++;
                }
            }
            if (count == i) {
                return i;
            }
        }
        return -1;

//        int len = nums.length;
//
//        for (int result = 0; result < len; result++) {
//            int count = 0;
//            for (int j = 0; j < len; j++) {
//                if (nums[j] >= result) count++;
//            }
//            if (count == result+1) return result+1;
//        }
//        return -1;
    }
}
