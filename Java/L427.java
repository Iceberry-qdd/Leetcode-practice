class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class L427 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1},
                {1, 0}};
        Node tree = construct(grid);
        System.out.println(tree);

        grid = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}};
        tree = construct(grid);
        System.out.println(tree);
    }

    public static Node construct(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;
        return quarterConstruct(grid, 0, 0, rowLen - 1, colLen - 1);
    }

    public static Node quarterConstruct(int[][] grid, int startRow, int startCol, int endRow, int endCol) {
        int rowLen = endRow - startRow + 1, colLen = endCol - startCol + 1;
        //if (startRow > endRow || startCol > endCol) return null;
        if (isSame(grid, startRow, startCol, endRow, endCol)) {
            return new Node(grid[startRow][startCol] == 1, true, null, null, null, null);
        }

        return new Node(false,
                false,
                quarterConstruct(grid, startRow, startCol, startRow + rowLen / 2 - 1, startCol + colLen / 2 - 1),//左上
                quarterConstruct(grid, startRow, startCol + colLen / 2, startRow + rowLen / 2 - 1, endCol),//右上
                quarterConstruct(grid, startRow + rowLen / 2, startCol, endRow, startCol + colLen / 2 - 1),//左下
                quarterConstruct(grid, startRow + rowLen / 2, startCol + colLen / 2, endRow, endCol));//右下
    }


    public static boolean isSame(int[][] grid, int startRow, int startCol, int endRow, int endCol) {
        int baseValue = grid[startRow][startCol];
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (grid[i][j] != baseValue) return false;
            }
        }
        return true;
    }
}
