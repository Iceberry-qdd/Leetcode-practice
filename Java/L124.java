public class L124 {
    public static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {1, 2, NULL, NULL, 3};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(maxPathSum(tree));

        arr = new int[]{-10, 9, NULL, NULL, 20, 15, NULL, NULL, 7};
        tree = new TreeNode2(arr).left;
        System.out.println(maxPathSum(tree));

        arr = new int[]{5, 4, 11, 7, NULL, NULL, 2, NULL, NULL, NULL, 8, 13, NULL, NULL, 4, NULL, 1};
        tree = new TreeNode2(arr).left;
        System.out.println(maxPathSum(tree));

        arr = new int[]{-3};
        tree = new TreeNode2(arr).left;
        System.out.println(maxPathSum(tree));
    }

    static int result = -1001;
    static final int MIN=-1001;

    public static int maxPathSum(TreeNode2 root) {
        result=MIN;
        int result1 = dfs(root);
        return max(result, result1);
    }

    public static int dfs(TreeNode2 root) {
        if (root == null) return MIN;
        int leftMaxSum = dfs(root.left);
        int rightMaxSum = dfs(root.right);
        int curResult = max(root.val,
                root.val + leftMaxSum,
                root.val + rightMaxSum);
        result = max(result,
                root.val + leftMaxSum + rightMaxSum,
                leftMaxSum,
                rightMaxSum);
        return curResult;
    }

    public static int max(int... nums) {
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            result = Math.max(result, num);
        }
        return result;
    }
}
