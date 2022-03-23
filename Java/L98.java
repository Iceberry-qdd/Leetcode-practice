import java.util.*;

public class L98 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {5, 1, NULL, NULL, 4, 3, NULL, NULL, 6};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(isValidBST(tree));

        arr = new int[]{2, 1, NULL, NULL, 3};
        tree = new TreeNode2(arr).left;
        System.out.println(isValidBST(tree));

        arr = new int[]{2, 1, NULL, NULL, 4, 3, NULL, NULL, 6};
        tree = new TreeNode2(arr).left;
        System.out.println(isValidBST(tree));

        arr = new int[]{5, 4, NULL, NULL, 6, 3, NULL, NULL, 7};
        tree = new TreeNode2(arr).left;
        System.out.println(isValidBST(tree));
    }


    public static boolean isValidBST(TreeNode2 root) {
        if (root == null) return true;

        Deque<TreeNode2> stack = new LinkedList<>();
        TreeNode2 pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode2 node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop();
                node = stack.pop();
                if (pre != null && pre.val >= node.val) {
                    return false;
                }
                pre = node;
            }
        }
        return true;
    }
}
