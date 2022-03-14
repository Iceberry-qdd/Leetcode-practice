import java.util.*;

public class L145 {
    public static void main(String[] args) {
        char[] arr = {'1', '#', '2', '3'};
        TreeNode tree = new TreeNode(arr).left;
        System.out.println(postorderTraversal(tree));
    }

    public static List<Character> postorderTraversal(TreeNode root) {
        List<Character> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        Collections.reverse(result);
        return result;
    }

}
