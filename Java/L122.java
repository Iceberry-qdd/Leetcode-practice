public class L122 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int result = 0, len = prices.length;
        if (len <= 1) return result;

        for (int i = 1; i < len; i++) {
            int curProfit = prices[i] - prices[i - 1];
            if (curProfit > 0) result += curProfit;
        }
        return result;
    }
}
