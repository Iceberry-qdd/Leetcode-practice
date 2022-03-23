public class L701 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {10, 6, 1, NULL, NULL, 4, NULL, NULL, 15, 13};
        TreeNode2 tree = new TreeNode2(arr).left;
        TreeNode2 result = insertIntoBST(tree, 8);
        System.out.println(result);
    }

    public static TreeNode2 insertIntoBST(TreeNode2 root, int val) {
        if (root == null) return new TreeNode2(val);

        if (root.val > val && root.left == null) {
            root.left = new TreeNode2(val);
            //return root;
        } else if (root.val < val && root.right == null) {
            root.right = new TreeNode2(val);
            //return root;
        } else if (root.val > val) {
            insertIntoBST(root.left, val);
            //return root;
        } else if (root.val < val) {
            insertIntoBST(root.right, val);
            //return root;
        }

        return root;
    }
}
