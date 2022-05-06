import java.util.*;

public class L1305 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr1 = {2, 1, NULL, NULL, 4}, arr2 = {1, 0, NULL, NULL, 3};
        TreeNode2 tree1 = new TreeNode2(arr1).left;
        TreeNode2 tree2 = new TreeNode2(arr2).left;
        List<Integer> result = getAllElements(tree1, tree2);
        System.out.println(result);
    }

    public static List<Integer> getAllElements(TreeNode2 root1, TreeNode2 root2) {
        List<Integer> result1 = getAllElements(root1);
        List<Integer> result2 = getAllElements(root2);

        result1.addAll(result2);
        result1.sort((e1, e2) -> e1 - e2);
        return result1;
    }

    public static List<Integer> getAllElements(TreeNode2 root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode2> stack = new LinkedList<>();
        if (root != null) stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode2 node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);

                stack.push(node);
                stack.push(null);

                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
