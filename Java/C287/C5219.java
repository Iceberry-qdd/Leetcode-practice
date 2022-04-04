package C287;

import java.util.Arrays;

public class C5219 {
    public static void main(String[] args) {
        int[] candies = {4, 7, 5};
        int result = maximumCandies(candies, 4);
        System.out.println(result);

    }

    public static int maximumCandies(int[] candies, long k) {
        long sum=0;
        for (int candy : candies) sum += candy;
        if (sum < k) return 0;

        long result = 0;
        long left = 1, right = sum;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (isMatch(candies, mid, k)) {
                left = mid + 1;
                result++;
            } else {
                right = mid - 1;
            }
        }
        return (int) result;
    }

    public static boolean isMatch(int[] candies, long eachHeapCandiesCount, long k) {
        int len = candies.length;
        for (int i = 0; i < len; i++) {
            k -= candies[i] / eachHeapCandiesCount;
        }

        return k <= 0;
    }
}
