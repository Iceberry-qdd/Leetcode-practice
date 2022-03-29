public class L55 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxRange = 0, len = nums.length;
        if (len == 1) return true;

        for (int i = 0; i <= maxRange; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);

            if (maxRange >= len - 1) return true;
        }

        return false;
    }
}
