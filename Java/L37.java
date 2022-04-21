import java.util.Arrays;

public class L37 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solveSudoku(char[][] board) {
        backTracing(board);
    }

    public static boolean backTracing(char[][] board) {
        int rowLen = 9, colLen = 9;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] != '.') continue;// 跳过已填充的数
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (backTracing(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int rowIndex, int colIndex, char num) {
        int rowLen = 9, colLen = 9;
        //该行有效？
        for (int i = 0; i < rowLen; i++) {
            if (board[rowIndex][i] == num) return false;
        }

        //该列有效？
        for (int i = 0; i < colLen; i++) {
            if (board[i][colIndex] == num) return false;
        }

        //每个3*3单元格有效？
        for (int i = (rowIndex / 3) * 3, i_backup = i; i < i_backup + 3; i++) {
            for (int j = (colIndex / 3) * 3, j_backup = j; j < j_backup + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}
