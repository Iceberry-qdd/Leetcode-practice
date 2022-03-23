import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class L450 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, NULL, NULL, 4, NULL, NULL, 6, NULL, 7};
        TreeNode2 tree = new TreeNode2(arr).left;
        TreeNode2 result = deleteNode(tree, 7);
        System.out.println(result);
    }

    public static TreeNode2 deleteNode(TreeNode2 root, int key) {
            if (root == null) return root;
            if (root.val == key) {
                if (root.left == null && root.right == null) return null;
                if (root.left == null && root.right != null) return root.right;
                if (root.left != null && root.right == null) return root.left;

                TreeNode2 rightTree = root.right;
                while (rightTree.left != null) {
                    rightTree = rightTree.left;
                }
                rightTree.left = root.left;
                root = root.right;
                return root;
            }

            if (root.val > key) root.left = deleteNode(root.left, key);
            if (root.val < key) root.right = deleteNode(root.right, key);
            return root;
        }
}
