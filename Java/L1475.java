import java.util.Arrays;

public class L1475 {
    public static void main(String[] args) {
        int[] result = finalPrices(new int[]{8, 4, 6, 2, 3});
        System.out.println(Arrays.toString(result));
        result=finalPrices(new int[]{8,7,4,2,8,1,7,7,10,1});
        System.out.println(Arrays.toString(result));
    }

    public static int[] finalPrices(int[] prices) {
        int len = prices.length;
        if (len == 1) return prices;

        int[] result = new int[len];
        for (int i = 0, j = 1; i < len; i++) {
            j = i + 1;
            while (j < len && (j <= i || prices[j] > prices[i])) {
                j++;
            }
            if (j == len) result[i] = prices[i];
            else result[i] = prices[i] - prices[j];
        }
        return result;
    }
}
