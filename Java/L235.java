public class L235 {
    public static void main(String[] args) {
        TreeNode2 tree = new TreeNode2(3, null, null);
        TreeNode2 p = new TreeNode2(5, null, null);
        TreeNode2 q = new TreeNode2(1, null, null);
        tree.left = p;
        tree.right = q;
        p.left = new TreeNode2(6, null, null);
        p.right = new TreeNode2(2, new TreeNode2(7), new TreeNode2(4));
        q.left = new TreeNode2(0, null, null);
        q.right = new TreeNode2(8, null, null);

        TreeNode2 result = lowestCommonAncestor(tree, p, q);
        System.out.println(result);
    }

    public static TreeNode2 lowestCommonAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if (root == null) return null;

        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
