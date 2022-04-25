public class L337 {
    public static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {3, 2, NULL, 3, NULL, NULL, 3, NULL, 1};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(rob(tree));
    }

    public static int rob(TreeNode2 root) {
        int[] result = robTree(root);
        return Math.max(result[0], result[1]);
    }

    public static int[] robTree(TreeNode2 root) {
        if (root == null) return new int[]{0, 0};
        int[] leftDp = robTree(root.left);
        int[] rightDp = robTree(root.right);

        int stealRootResult = root.val + leftDp[0] + rightDp[0];
        int noStealRootResult = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);
        return new int[]{noStealRootResult, stealRootResult};
    }
}
