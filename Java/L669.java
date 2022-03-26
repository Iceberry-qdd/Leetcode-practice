public class L669 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {1, 0, NULL, NULL, 2};
        TreeNode2 tree = new TreeNode2(arr).left;
        TreeNode2 result = trimBST(tree, 1, 2);
        System.out.println(result);
    }

    public static TreeNode2 trimBST(TreeNode2 root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
