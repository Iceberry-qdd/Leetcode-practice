import java.util.Arrays;

public class L942 {
    public static void main(String[] args) {
        int[] result = diStringMatch("IDID");
        System.out.println(Arrays.toString(result));
        result = diStringMatch("III");
        System.out.println(Arrays.toString(result));
        result = diStringMatch("DDI");
        System.out.println(Arrays.toString(result));
    }

    public static int[] diStringMatch(String s) {
        int len = s.length();
        int[] nums = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            nums[i] = i;
        }
        int left = 0, right = len, i;
        int[] result = new int[len + 1];
        for (i = 0; i < len; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = nums[left++];
            }
            if (s.charAt(i) == 'D') {
                result[i] = nums[right--];
            }
        }
        result[i] = nums[left];
        return result;
    }
}
