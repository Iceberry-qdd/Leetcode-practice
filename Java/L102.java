import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102 {
    public static void main(String[] args) {
        char[] arr = {'3', '9','#','#', '2',  '1','#','#', '7'};
        TreeNode tree = new TreeNode(arr).left;
        System.out.println(levelOrder(tree));
    }

    public static List<List<Character>> levelOrder(TreeNode root) {
        List<List<Character>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Character> levelResult = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                levelResult.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            result.add(levelResult);
        }
        return result;
    }
}
