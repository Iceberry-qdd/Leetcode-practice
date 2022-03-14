import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L199 {
    public static void main(String[] args) {
        char[] arr = {'1', '2', '4', '#', '#', '#', '3'};
        TreeNode tree = new TreeNode(arr).left;
        System.out.println(rightSideView(tree));
    }

    public static List<Character> rightSideView(TreeNode root) {
        List<Character> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<TreeNode> levelNode = new ArrayList<>();
            while (len > 0) {
                TreeNode node = queue.pop();
                levelNode.add(node);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                len--;
            }
            TreeNode rightNode = levelNode.get(levelNode.size() - 1);
            result.add(rightNode.val);
        }
        return result;
    }
}
