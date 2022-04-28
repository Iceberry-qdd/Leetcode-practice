public class L968 {
    public static final int NULL = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, NULL, NULL, 0, NULL, NULL,NULL};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(minCameraCover(tree));
    }

    public static final int UNCOVERED = 0;
    public static final int WITH_CAMERA = 1;
    public static final int COVERED = 2;
    public static int result = 0;

    public static int minCameraCover(TreeNode2 root) {
        result = 0;
        if (dfs(root) == UNCOVERED) result++;
        return result;
    }

    public static int dfs(TreeNode2 root) {
        if (root == null) return COVERED;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == COVERED && right == COVERED) return UNCOVERED;
        if (left == UNCOVERED || right == UNCOVERED) {
            result++;
            return WITH_CAMERA;
        }
        if (left == WITH_CAMERA || right == WITH_CAMERA) return COVERED;
        return -1;
    }
}
