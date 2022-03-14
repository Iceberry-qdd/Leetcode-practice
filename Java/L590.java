import java.util.*;

/*
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

 */

public class L590 {
    public static void main(String[] args) {
        char[] arr = {'1', '#', '3', '2', '#', '#', '4', '#', '5', '6'};
        TreeNode tree = new TreeNode(arr).left;
        System.out.println(postorder(tree));
    }

    public static List<Character> postorder(TreeNode root) {
        List<Character> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop();
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
