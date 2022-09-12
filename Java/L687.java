public class L687 {
    public static void main(String[] args) {

    }

    static int result = 0;

    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        getMaxLen(root, root.val);
        return result;
    }

    public static int getMaxLen(TreeNode root, int val) {
        if (root == null) return 0;
        int left = getMaxLen(root.left, root.val);
        int right = getMaxLen(root.right, root.val);
        result = Math.max(result, left + right);
        if (root.val == val) return Math.max(left, right) + 1;
        return 0;
    }
}
