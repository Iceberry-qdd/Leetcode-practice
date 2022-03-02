public class L1343 {
    public static void main(String[] args) {
//        int[] arr={2,2,2,2,5,5,5,8};
//        int k=3,threshold=4;
        System.out.println(numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println(numOfSubarrays(new int[]{1, 1, 1, 1, 1}, 1, 0));
        System.out.println(numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
        System.out.println(numOfSubarrays(new int[]{7, 7, 7, 7, 7, 7, 7}, 7, 7));
        System.out.println(numOfSubarrays(new int[]{4, 4, 4, 4}, 4, 1));

    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int len = arr.length, left = 0, sum = 0, count = 0;
        for (int right = 0; right < len; right++) {
            sum += arr[right];
            if (right - left + 1 == k) {
                if (sum / k >= threshold) count++;
                sum -= arr[left];
                left++;
            }
        }
        return count;
    }
}
