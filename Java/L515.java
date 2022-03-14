import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L515 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2, TreeNode2.NULL_NODE, 9};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(largestValues(tree));
    }

    public static List<Integer> largestValues(TreeNode2 root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode2> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            while (len > 0) {
                TreeNode2 node = queue.pop();
                max = Math.max(max, node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                len--;
            }
            result.add(max);
        }
        return result;
    }
}
