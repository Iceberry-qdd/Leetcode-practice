import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L501 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {1, NULL, 2, 2};
        TreeNode2 tree = new TreeNode2(arr).left;
        int[] result = findMode(tree);
        System.out.println(Arrays.toString(result));
    }

    static List<Integer> result = new ArrayList<>();
    public static int[] findMode(TreeNode2 root) {
        traversal(root);

        int[] neuter = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            neuter[i] = result.get(i);
        }
        return neuter;

    }

    static int count, maxCount;
    static TreeNode2 pre;
    public static void traversal(TreeNode2 root) {
        if (root == null) return;
        traversal(root.left);

        if (pre == null || root.val != pre.val) count = 1;
        else count++;

        if (count > maxCount) {
            result.clear();
            result.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            result.add(root.val);
        }
        pre = root;

        traversal(root.right);
    }
}
