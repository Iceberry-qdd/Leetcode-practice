import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class L226 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 7, 6, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 9};
        TreeNode2 tree = new TreeNode2(arr).left;
        TreeNode2 treeNode2 = invertTree(tree);
        System.out.println(treeNode2);
    }

    // 层序遍历
    public static TreeNode2 invertTree(TreeNode2 root) {
        Deque<TreeNode2> queue = new LinkedList<>();
        if (root != null) queue.push(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode2 node = queue.pop();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);

                TreeNode2 temp = node.left;
                node.left = node.right;
                node.right = temp;
                len--;
            }
        }
        return root;
    }
}
