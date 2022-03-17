import java.util.Deque;
import java.util.LinkedList;

public class L100 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3};
        int[] arr2 = {1, 2, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3};
        TreeNode2 tree1 = new TreeNode2(arr1).left;
        TreeNode2 tree2 = new TreeNode2(arr2).left;
        System.out.println(isSameTree(tree1, tree2));

        arr1 = new int[]{1, 3, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2};
        arr2 = new int[]{1, 2, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 3};
        tree1 = new TreeNode2(arr1).left;
        tree2 = new TreeNode2(arr2).left;
        System.out.println(isSameTree(tree1, tree2));

        arr1 = new int[]{1, 2};
        arr2 = new int[]{1, TreeNode2.NULL_NODE, 2};
        tree1 = new TreeNode2(arr1).left;
        tree2 = new TreeNode2(arr2).left;
        System.out.println(isSameTree(tree1, tree2));
    }

    public static boolean isSameTree(TreeNode2 p, TreeNode2 q) {
        if (p == null && q == null) return true;

        Deque<TreeNode2> stack = new LinkedList<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            TreeNode2 qNode = stack.pop();
            TreeNode2 pNode = stack.pop();
            if (qNode != null && pNode != null) {

                if (pNode.right != null && qNode.right != null) {
                    stack.push(pNode.right);
                    stack.push(qNode.right);
                } else if (pNode.right != null || qNode.right != null) {
                    return false;
                }

                if (pNode.left != null && qNode.left != null) {
                    stack.push(pNode.left);
                    stack.push(qNode.left);
                } else if (pNode.left != null || qNode.left != null) {
                    return false;
                }

                stack.push(pNode);
                stack.push(qNode);
                stack.push(null);
                stack.push(null);
            } else {
                qNode = stack.pop();
                pNode = stack.pop();
                if (qNode.val != pNode.val) return false;
            }
        }
        return true;
    }
}
