public class L108 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        TreeNode2 tree = sortedArrayToBST(arr);
        System.out.println(tree);
    }

    public static TreeNode2 sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    public static TreeNode2 traversal(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode2 root = new TreeNode2(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
