import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class M0406 {
    public static void main(String[] args) {
        TreeNode2 tree = new TreeNode2(2);
        TreeNode2 p = new TreeNode2(1);
        tree.left = p;
        tree.right = new TreeNode2(3);
        TreeNode2 result = inorderSuccessor(tree, p);
        System.out.println(result.val);
    }

    public static TreeNode2 inorderSuccessor(TreeNode2 root, TreeNode2 p) {
        Deque<TreeNode2> stack = new LinkedList<>();
        TreeNode2 lastNode = null;
        if (root != null) stack.push(root);
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
                node = stack.peek();
                stack.pop();

                if (lastNode == p) return node;
                lastNode = node;
            }
        }
        return null;
    }
}
