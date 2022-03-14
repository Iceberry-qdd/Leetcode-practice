public class L111 {
    public static void main(String[] args) {
        int[] arr = {3, 9, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 20, 15, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 7};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(minDepth(tree));
        arr = new int[]{2, TreeNode2.NULL_NODE, 3, TreeNode2.NULL_NODE, 4, TreeNode2.NULL_NODE, 5, TreeNode2.NULL_NODE, 6};
        tree = new TreeNode2(arr).left;
        System.out.println(minDepth(tree));
    }

    public static int minDepth(TreeNode2 root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
