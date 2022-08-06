public class L623 {
    public static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, NULL, NULL, 1, NULL, NULL, 6, 5};
        TreeNode2 tree = new TreeNode2(arr).left;
        TreeNode2 result = addOneRow(tree, 1, 2);
        System.out.println(result);
    }

    public static TreeNode2 addOneRow(TreeNode2 root, int val, int depth) {
        if (root == null) return null;
        if (depth > 2) {
            addOneRow(root.left, val, depth - 1);
            addOneRow(root.right, val, depth - 1);
            return root;
        } else if (depth == 2) {
            root.left = new TreeNode2(val, root.left, null);
            root.right = new TreeNode2(val, null, root.right);
            return root;
        } else {
            return new TreeNode2(val, root, null);
        }
    }
}
