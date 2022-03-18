import java.util.Deque;
import java.util.LinkedList;

public class L617 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] root1 = {1, 3, 5, NULL, NULL, NULL, 2}, root2 = {2, 1, NULL, 4, NULL, NULL, 3, NULL, 7};
        TreeNode2 tree1 = new TreeNode2(root1).left, tree2 = new TreeNode2(root2).left;

        TreeNode2 mergeTree = mergeTrees(tree1, tree2);
        System.out.println(mergeTree);

        tree1 = null;
        tree2 = null;

        mergeTree = mergeTrees(tree1, tree2);
        System.out.println(mergeTree);
    }

    public static TreeNode2 mergeTrees(TreeNode2 root1, TreeNode2 root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Deque<TreeNode2> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode2 node1 = queue.pop();
            TreeNode2 node2 = queue.pop();

            node1.val = node1.val + node2.val;

            if (node1.left != null && node2.left != null) {
                queue.addLast(node1.left);
                queue.addLast(node2.left);
            }

            if (node1.right != null && node2.right != null) {
                queue.addLast(node1.right);
                queue.addLast(node2.right);
            }

            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }

            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
