import java.util.Arrays;

public class L88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{1};
        nums2 = new int[]{};
        merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{2, 0};
        nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            while (n > 0) nums1[n - 1] = nums2[-1 + n--];
            return;
        }
        if (n == 0) return;

        int len1 = m + n, i = 0;
        while (m >= 0 && n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[len1 - 1 - i] = nums1[m - 1];
                m--;
            } else {
                nums1[len1 - 1 - i] = nums2[n - 1];
                n--;
            }
            i++;
        }
    }
}
