import java.util.Arrays;

public class L646 {
    public static void main(String[] args) {
        int result = findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}});
        System.out.println(result);

        result = findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}});
        System.out.println(result);
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> {
            return p1[1] - p2[1];
        });

        int temp = pairs[0][1], result = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > temp) {
                result++;
                temp = pairs[i][1];
            }
        }
        return result;
    }
}
