public class L236 {
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
        if (root == p || root == q || root == null) return root;

        TreeNode2 left = lowestCommonAncestor(root.left, p, q);
        TreeNode2 right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
