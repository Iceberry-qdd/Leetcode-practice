import java.util.Arrays;

public class L875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + right >> 1;
            if (canEatAll(mid, h, piles)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean canEatAll(int speed, int h, int[] piles) {
        int hour = 0;
        for (int pile : piles) {
            hour += Math.ceil((pile * 1.0) / speed);
        }
        return hour <= h;
    }
}
