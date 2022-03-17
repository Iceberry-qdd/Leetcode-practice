import java.util.Deque;
import java.util.LinkedList;

public class L404 {
    public static void main(String[] args) {
        int[] arr = {3, 9, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 20, 15, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 7};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(sumOfLeftLeaves(tree));

    }

    public static int sumOfLeftLeaves(TreeNode2 root) {
        Deque<TreeNode2> queue = new LinkedList<>();
        if (root != null) queue.push(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode2 node = queue.pop();

                if (node!=null){
                    if (node.left != null && node.left.left == null && node.left.right == null){
                        count += node.left.val;
                    }
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
        }
        return count;
    }

}
