public class L883 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};
        System.out.println(projectionArea(grid));

        grid = new int[][]{{1, 0}, {0, 2}};
        System.out.println(projectionArea(grid));

        grid = new int[][]{{1, 0}, {5,4}};
        System.out.println(projectionArea(grid));
    }

    public static int projectionArea(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length, result = 0;
        result += rowLen * colLen; // xy面的面积为grid元素个数
        for (int i = 0; i < rowLen; i++) {
            int xMaxCount = 0,yMaxCount = 0;;
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 0){
                    result--;
                    //continue;
                }
                xMaxCount = Math.max(xMaxCount, grid[i][j]);
                yMaxCount = Math.max(yMaxCount, grid[j][i]);
            }
            result += xMaxCount; // xz面的面积
            result += yMaxCount;// yz面的面积
        }

        return result;
    }
}
