import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51 {
    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }

    static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backTracing(board, 0);
        return result;
    }

    static List<String> item = new ArrayList<>();

    public static void backTracing(char[][] board, int row) {
        int rowLen = board.length, colLength = board.length;
        if (row == rowLen) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < colLength; i++) {
            board[row][i] = 'Q';
            if (isValid(board, row, i)) {
                item.add(String.valueOf(board[row]));
            } else {
                board[row][i] = '.';
                continue;
            }
            backTracing(board, row + 1);
            board[row][i] = '.';
            item.remove(item.size() - 1);
        }
    }

    public static boolean isValid(char[][] board, int row, int col) {
        int colLength = board.length;
        //列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        //斜45度角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        //斜135度角
        for (int i = row - 1, j = col + 1; i >= 0 && j < colLength; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
