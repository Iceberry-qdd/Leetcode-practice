public class L606 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, NULL, NULL, NULL, 3};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(tree2str(tree));
    }

    public static String tree2str(TreeNode2 root) {
        StringBuilder result = new StringBuilder();
        if (root == null) return result.toString();
        if (root.left == null && root.right == null) {
            result.append(root.val);
            return result.toString();
        }
        result.append(root.val);
        if (root.left != null) {
            result.append('(').append(tree2str(root.left)).append(')');
        } else {
            result.append("()");
        }
        if (root.right != null) {
            result.append('(').append(tree2str(root.right)).append(')');
        }
        return result.toString();
    }
}
