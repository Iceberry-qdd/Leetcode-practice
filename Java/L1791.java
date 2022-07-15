public class L1791 {
    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
        System.out.println(findCenter(new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}}));
    }

    public static int findCenter(int[][] edges) {
        int len = edges.length;
        int[] degrees = new int[len + 2];
        for (int i = 0; i < degrees.length; i++) {
            degrees[edges[i][1]]++;
            degrees[edges[i][0]]++;
            if (degrees[edges[i][1]] > 1) return edges[i][i];
            if (degrees[edges[i][0]] > 1) return edges[i][0];
        }
        return -1;
    }
}
