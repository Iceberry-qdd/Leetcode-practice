package C285;

public class C6027 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 1, 6, 5};
        int result = countHillValley(nums);
        System.out.println(result);

        nums = new int[]{6, 6, 5, 4, 1};
        result = countHillValley(nums);
        System.out.println(result);

        nums = new int[]{6, 6, 6, 6, 5, 4, 1};
        result = countHillValley(nums);
        System.out.println(result);

        nums = new int[]{57,57,57,57,57,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,85,85,85,86,86,86};
        result = countHillValley(nums);
        System.out.println(result);
    }

    public static int countHillValley(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 1; i < len - 1; i++) {
            int left = i - 1, right = i + 1;

            while (left > 0 && nums[left] == nums[i]) {
                left--;
            }

            while (right < len-1 && nums[right] == nums[i]) {
                right++;
                i++;
            }

            if (nums[i] > nums[left] && nums[i] > nums[right]) {
                count++;
            }

            if (nums[i] < nums[left] && nums[i] < nums[right]) {
                count++;
            }
        }
        return count;
    }
}
