import java.util.ArrayDeque;
import java.util.Deque;

public class L104 {
    public static void main(String[] args) {
        int[] arr = {3, 9, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 20, 15, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 7};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(maxDepth(tree));
    }

    public static int maxDepth(TreeNode2 root) {
        int depth = 0;
        Deque<TreeNode2> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode2 node = queue.pop();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                len--;
            }
            depth++;
        }
        return depth;
    }
}
