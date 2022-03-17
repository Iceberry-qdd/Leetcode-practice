import java.util.ArrayList;
import java.util.List;

public class L113 {
    public static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {5, 4, 11, 7, NULL, NULL, 2, NULL, NULL, NULL, 8, 13, NULL, NULL, 4, 5, NULL, NULL, 1};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(pathSum(tree, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode2 root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return result;
        traversal(root, result, path, targetSum);
        return result;

    }

    public static void traversal(TreeNode2 root, List<List<Integer>> result, List<Integer> path, int targetSum) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (Integer p : path) {
                sum += p;
            }

            if (sum == targetSum) {
                List<Integer> thisPath = new ArrayList<>(path);
                result.add(thisPath);
            }
        }

        if (root.left != null) {
            traversal(root.left, result, path, targetSum);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            traversal(root.right, result, path, targetSum);
            path.remove(path.size() - 1);
        }
    }
}
