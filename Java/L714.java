public class L714 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int minPrice = prices[0], result = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            if (prices[i] >= minPrice && prices[i] <= minPrice + fee) {
                continue;
            }

            if (prices[i] > minPrice) {
                result += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee;
            }
        }
        return result;
    }
}
