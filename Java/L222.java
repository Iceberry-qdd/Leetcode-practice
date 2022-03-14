public class L222 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 5, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3, 6, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(countNodes(tree));

        arr = new int[]{1};
        tree = new TreeNode2(arr).left;
        System.out.println(countNodes(tree));
    }

    public static int countNodes(TreeNode2 root) {
        if (root == null) return 0;
        TreeNode2 left = root.left;
        TreeNode2 right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.left;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
