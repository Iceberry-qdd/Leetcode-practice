public class L1217 {
    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{1, 2, 3}));
        System.out.println(minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
    }

    public static int minCostToMoveChips(int[] position) {
        int len = position.length;
        int oddCount = 0, evenCount = 0;
        for (int i = 0; i < len; i++) {
            if (position[i] % 2 == 0) oddCount++;
        }
        evenCount = len - oddCount;
        return Math.min(oddCount, evenCount);
    }
}
