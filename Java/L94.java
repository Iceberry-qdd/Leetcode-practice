import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L94 {
    public static void main(String[] args) {
        char[] arr = {'1', '#', '2', '3'};
        TreeNode tree = new TreeNode(arr).left;
        System.out.println(inorderTraversal(tree));
    }

    public static List<Character> inorderTraversal(TreeNode root) {
        List<Character> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
