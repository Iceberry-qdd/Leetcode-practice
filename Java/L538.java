public class L538 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {4, 1, 0, NULL, NULL, 2, NULL, 3, NULL, NULL, 6, 5, NULL, NULL, 7, NULL, 8};
        TreeNode2 tree = new TreeNode2(arr).left;
        TreeNode2 result = convertBST(tree);
        System.out.println(result);
    }

    static int pre = 0;

    public static TreeNode2 convertBST(TreeNode2 root) {
        traversal(root);
        return root;
    }

    public static void traversal(TreeNode2 root) {
        if (root == null) return;
        traversal(root.right);
        root.val += pre;
        pre = root.val;
        traversal(root.left);
    }
}
