import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    private static int i = 0;
    public static final int NULL_NODE = Integer.MIN_VALUE;

    TreeNode2() {}

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode2(int[] arr) {
        i = 0;
        this.left = createBTree(arr, this);
    }

    private TreeNode2 createBTree(int[] data, TreeNode2 node) {
        if (i >= data.length) return node;
        if (data[i++] != NULL_NODE) {
            node = new TreeNode2(data[i - 1], null, null);
            node.left = createBTree(data, node.left);
            node.right = createBTree(data, node.right);
        } else node = null;
        return node;
    }
}

public class L637 {
    public static void main(String[] args) {
        int[] arr = {3, 9, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 20, 15, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 7};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(averageOfLevels(tree));
    }

    public static List<Double> averageOfLevels(TreeNode2 root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode2> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size(), i = 0;
            double sum = 0;
            while (i < len) {
                TreeNode2 node = queue.pop();
                sum += node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                i++;
            }
            result.add(sum / i);
        }
        return result;
    }
}
