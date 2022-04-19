import java.util.*;

public class L103 {
    public static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {3, 9, NULL, NULL, 20, 15, NULL, NULL, 7};
        TreeNode2 tree = new TreeNode2(arr).left;
        List<List<Integer>> result = zigzagLevelOrder(tree);
        System.out.println(result);

        arr = new int[]{1, 2, 4, NULL, NULL, NULL, 3, NULL, 5};
        tree = new TreeNode2(arr).left;
        result = zigzagLevelOrder(tree);
        System.out.println(result);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode2 root) {
        Deque<TreeNode2> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean rightToLeft = true;

        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> item = new ArrayList<>(len);
            while (len > 0) {
                TreeNode2 node = queue.pop();
                item.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            if (!rightToLeft) Collections.reverse(item);
            result.add(item);
            rightToLeft = !rightToLeft;
        }
        return result;
    }
}
