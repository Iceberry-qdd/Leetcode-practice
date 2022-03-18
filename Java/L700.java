public class L700 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, NULL, NULL, 3, NULL, NULL, 7};
        int val = 2;
        TreeNode2 tree = new TreeNode2(arr).left;
        TreeNode2 result = searchBST(tree, val);
        System.out.println(result);
    }

    public static TreeNode2 searchBST(TreeNode2 root, int val) {
        if (root == null) return null;
        else if (root.val == val) return root;

        TreeNode2 searchLeft = searchBST(root.left, val);
        TreeNode2 searchRight = searchBST(root.right, val);

        return searchLeft != null ? searchLeft : searchRight;
    }
}
