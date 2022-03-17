public class L513 {
    public static void main(String[] args) {
        int[] arr = {2, 1, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(findBottomLeftValue(tree));

        arr = new int[]{1, 2, 4, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3, 5, 7, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 6};
        tree = new TreeNode2(arr).left;
        System.out.println(findBottomLeftValue(tree));

        arr = new int[]{1};
        tree = new TreeNode2(arr).left;
        System.out.println(findBottomLeftValue(tree));
    }

    static int maxDepth = 0;
    static int bottomLeftValue = -1;
    public static int findBottomLeftValue(TreeNode2 root) {
        traversal(root, 0);
        return bottomLeftValue;
    }

    public static void traversal(TreeNode2 root, int leftDepth) {
        if (root.left == null && root.right == null) {
            if (leftDepth > maxDepth) {
                maxDepth = leftDepth;
                bottomLeftValue = root.val;
            }
        }
        if (root.left != null) {
            traversal(root.left, leftDepth + 1);
        }

        if (root.right != null) {
            traversal(root.right, leftDepth + 1);
        }
    }
}
