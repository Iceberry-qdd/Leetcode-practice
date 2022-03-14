import java.util.*;

public class L107 {
    public static void main(String[] args) {
        char[] arr = {'3', '9', '#', '#', '2', '1', '#', '#', '7'};
        TreeNode tree = new TreeNode(arr).left;
        System.out.println(levelOrderBottom(tree));
    }

    public static List<List<Character>> levelOrderBottom(TreeNode root) {
        List<List<Character>> result = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.push(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Character> levelResult = new ArrayList<>();
            while (len > 0) {
                TreeNode node = queue.pop();
                levelResult.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                len--;
            }
            result.add(levelResult);
        }
        Collections.reverse(result);
        return result;
    }
}
