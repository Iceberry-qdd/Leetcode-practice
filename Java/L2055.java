import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2055 {
    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = {{2, 5}, {5, 9}};
        System.out.println(Arrays.toString(platesBetweenCandles(s, queries)));
        s = "***|**|*****|**||**|*";
        queries = new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}, {12, 12}};
        System.out.println(Arrays.toString(platesBetweenCandles(s, queries)));
        s = "*|*||||**|||||||*||*||*||**|*|*||*";
        queries = new int[][]{{2, 33}, {2, 32}, {3, 31}, {0, 33}, {1, 24}, {3, 20}, {7, 11}, {5, 32}, {2, 31}, {5, 31}, {0, 31}, {3, 28}, {4, 33}, {6, 29}, {2, 30}, {2, 28}, {1, 30}, {1, 33}, {4, 32}, {5, 30}, {4, 23}, {0, 30}, {3, 10}, {5, 28}, {0, 28}, {4, 28}, {3, 33}, {0, 27}};
        System.out.println(Arrays.toString(platesBetweenCandles(s, queries)));
        s = "**|**|***|";
        queries = new int[][]{{2, 2}};
        System.out.println(Arrays.toString(platesBetweenCandles(s, queries)));
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int lenS = s.length(), lenQ = queries.length;

        // 预处理，空间换时间
        int[] candlesL = new int[lenS + 1];// 存储每个位置上离盘子最近的左边蜡烛下标，candlesL[0]作为哨兵
        int[] candlesR = new int[lenS + 1];// 存储每个位置上离盘子最近的右边蜡烛下标，candlesR[lenS]作为哨兵
        int[] preSum = new int[lenS + 1]; // preSum[0]作为哨兵
        init(s, candlesL, candlesR, preSum);

        int[] result = new int[lenQ];
        for (int i = 0; i < lenQ; i++) {
            int right = candlesL[queries[i][1] + 1];
            int left = candlesR[queries[i][0]];
            result[i] = left < right ? preSum[right] - preSum[left] : 0;
        }
        return result;
    }

    public static void init(String s, int[] candlesL, int[] candlesR, int[] preSum) {
        int len = s.length();
        candlesL[0]=0;
        candlesR[len]=Integer.MAX_VALUE;
        preSum[0]=0;
        for (int i = 0; i < len; i++) {
            candlesL[i + 1] = s.charAt(i) == '|' ? i : candlesL[i];
            candlesR[len - i - 1] = s.charAt(len - i - 1) == '|' ? len - i - 1 : candlesR[len - i];
            preSum[i + 1] = s.charAt(i) == '|' ? preSum[i] : preSum[i] + 1;
        }
    }
}
