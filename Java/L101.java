import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class L101 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 4, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2, 4, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3};
        TreeNode2 tree = new TreeNode2(arr).left;
        boolean isSame = isSymmetric(tree);
        System.out.println(isSame);

        arr = new int[]{1, 2, TreeNode2.NULL_NODE, 3, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2, TreeNode2.NULL_NODE, 3};
        tree = new TreeNode2(arr).left;
        isSame = isSymmetric(tree);
        System.out.println(isSame);

        arr = new int[]{2, 3, 4, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 5, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3, 5, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE};
        tree = new TreeNode2(arr).left;
        isSame = isSymmetric(tree);
        System.out.println(isSame);
    }

    public static boolean isSymmetric(TreeNode2 root) {
        if (root == null) return true;
        Deque<TreeNode2> stack = new LinkedList<>();

        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode2 right = stack.pop();
            TreeNode2 left = stack.pop();

            if (left == null && right != null) return false;
            else if (left != null && right == null) return false;
            else if (left == null && right == null) return true;
            else if (left.val != right.val) return false;

            if (left.left != null || right.right != null) {
                stack.push(left.left);
                stack.push(right.right);
            }

            if (left.right != null || right.left != null) {
                stack.push(left.right);
                stack.push(right.left);
            }
        }
        return true;
    }
}
