public class L540 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 2, 3}));

    }

    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length, left = 0, right = len - 1, mid;
        if (len == 1) return nums[0];
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
