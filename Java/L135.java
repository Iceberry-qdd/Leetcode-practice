import java.util.Arrays;

public class L135 {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));

        ratings = new int[]{1, 2, 2};
        System.out.println(candy(ratings));

        ratings = new int[]{1, 3, 2, 2, 1};
        System.out.println(candy(ratings));

        ratings = new int[]{1, 2, 87, 87, 87, 2, 1};
        System.out.println(candy(ratings));

        ratings = new int[]{1, 2, 87, 87, 87};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int len = ratings.length, result = 0;
        int[] candy = new int[len];
        Arrays.fill(candy, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        for (int i = 0; i < len; i++) {
            result += candy[i];
        }
        return result;
    }
}
