import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    private static int i = 0;

    TreeNode() {
    }

    TreeNode(char val) {
        this.val = val;
    }

    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(char[] arr) {
        i = 0;
        this.left = createBTree(arr, this);
    }

    private TreeNode createBTree(char[] data, TreeNode node) {
        if (i >= data.length) return node;
        if (data[i++] != '#') {
            node = new TreeNode(data[i - 1], null, null);
            node.left = createBTree(data, node.left);
            node.right = createBTree(data, node.right);
        } else node = null;
        return node;
    }
}

public class L144 {

    public static void main(String[] args) {
        char[] arr = {'1', '#', '2', '3'};
        TreeNode tree = new TreeNode(arr).left;
        System.out.println(preorderTraversal(tree));
        arr = new char[]{'1', '#', '2'};
        tree = new TreeNode(arr).left;
        System.out.println(preorderTraversal(tree));
        arr = new char[]{'3', '2', '1'};
        tree = new TreeNode(arr).left;
        System.out.println(preorderTraversal(tree));
    }

    public static List<Character> preorderTraversal(TreeNode root) {
        List<Character> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);// 根节点入栈
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
