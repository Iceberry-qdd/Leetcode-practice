import Annotation.PrintDuration;
import Annotation.Processor;

public class L110 {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 20, 15, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 7};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(isBalanced(tree));

        arr=new int[]{1,2,3,4,TreeNode2.NULL_NODE,TreeNode2.NULL_NODE,4,TreeNode2.NULL_NODE,TreeNode2.NULL_NODE,3,TreeNode2.NULL_NODE,TreeNode2.NULL_NODE,2};
        tree = new TreeNode2(arr).left;
        System.out.println(isBalanced(tree));
    }

    @PrintDuration
    public static boolean isBalanced(TreeNode2 root) {
        return getHeight(root) != -1;
    }

    public static int getHeight(TreeNode2 root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        else return 1 + Math.max(leftHeight, rightHeight);
    }
}
