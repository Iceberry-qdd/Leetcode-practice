public class L33 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 3));

        nums = new int[]{1};
        System.out.println(search(nums, 0));

        nums = new int[]{1, 3};
        System.out.println(search(nums, 1));

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(search(nums, 4));

        nums = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(search(nums, 4));
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[0]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int midSearch(int[] nums, int left, int right, int target) {
        if (right < left) right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }
}
