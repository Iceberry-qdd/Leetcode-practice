import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class L1022 {
    public static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, NULL, NULL, 1, NULL, NULL, 1, 0, NULL, NULL, 1};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(sumRootToLeaf(tree));
    }

    static List<Integer> nums = new ArrayList<>();

    public static int sumRootToLeaf(TreeNode2 root) {
        dfs(root, "");
        int result = 0;
        for (Integer num : nums) {
            result += num;
        }
        return result;
    }

    static StringBuilder sb = new StringBuilder();

    public static void dfs(TreeNode2 root, String path) {
        if (root == null) return;
        path += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            nums.add(Integer.parseInt(path, 2));
            return;
        }

        dfs(root.left, path);
        dfs(root.right, path);
    }
}
