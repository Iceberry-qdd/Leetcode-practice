package C292;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    private static int i = 0;
    public static final int NULL_NODE = Integer.MIN_VALUE;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int[] arr) {
        i = 0;
        this.left = createBTree(arr, this);
    }

    private TreeNode createBTree(int[] data, TreeNode node) {
        if (i >= data.length) return node;
        if (data[i++] != NULL_NODE) {
            node = new TreeNode(data[i - 1], null, null);
            node.left = createBTree(data, node.left);
            node.right = createBTree(data, node.right);
        } else node = null;
        return node;
    }
}

public class C6057 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 0, TreeNode.NULL_NODE, TreeNode.NULL_NODE, 1, TreeNode.NULL_NODE, TreeNode.NULL_NODE, 5, TreeNode.NULL_NODE, 6};
        TreeNode tree = new TreeNode(arr).left;
        System.out.println(averageOfSubtree(tree));
    }

    public static int result = 0;
    public static int averageOfSubtree(TreeNode root) {
        result = 0;
        if (root == null) return 0;
        dfs(root);
        return result;
    }

    public static int dfs(TreeNode root) {
        int leftSum = 0, rightSum = 0;
        if (root.left != null) leftSum = dfs(root.left);
        if (root.right != null) rightSum = dfs(root.right);

        count = 0;
        getNodeCount(root);
        int avg = (leftSum + rightSum + root.val) / count;
        if (avg == root.val) result++;
        return leftSum + rightSum + root.val;
    }

    public static int count = 0;
    public static void getNodeCount(TreeNode root) {
        if (root != null) count++;
        else return;
        getNodeCount(root.left);
        getNodeCount(root.right);
    }
}
