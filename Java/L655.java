import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L655 {
    public static void main(String[] args) {

    }

    private static int height = 0;
    private static int[][] result;

    public static List<List<String>> printTree(TreeNode root) {
        getHeight(root, 0);
        int m = height + 1;
        int n = 2 << (m-1) - 1;
        result = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], -100);
        }

        fillArray(root, 0, (n - 1) / 2);
        List<List<String>> list = convertToList(result);
        return list;
    }

    private static List<List<String>> convertToList(int[][] result) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            List<String> item = new ArrayList<>();
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] != -100) {
                    item.add(String.valueOf(result[i][j]));
                } else {
                    item.add("");
                }
            }
            list.add(item);
        }
        return list;
    }

    private static void fillArray(TreeNode root, int r, int c) {
        result[r][c] = root.val;
        int k = 1 << (height - r - 1);
        if (root.left != null) fillArray(root.left, r + 1, c - k);
        if (root.right != null) fillArray(root.right, r + 1, c + k);
    }

    private static void getHeight(TreeNode root, int h) {
        if (h > height) height = h;
        if (root.left != null) getHeight(root.left, h + 1);
        if (root.right != null) getHeight(root.right, h + 1);
    }
}
