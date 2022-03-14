import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L257 {
    public static void main(String[] args) {
        int[] arr = {1, 2, TreeNode2.NULL_NODE, 5, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3};
        TreeNode2 tree = new TreeNode2(arr).left;
        List<String> result = binaryTreePaths(tree);
        System.out.println(result);
    }

    public static List<String> binaryTreePaths(TreeNode2 root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Object> stack = new ArrayDeque<>();
        stack.push(root);
        stack.push(root.val);

        while (!stack.isEmpty()) {
            String path = String.valueOf(stack.pop());
            TreeNode2 node = (TreeNode2) stack.pop();

            if (node.left == null && node.right == null) {
                result.add(path);
            }

            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }

            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
    }
}
