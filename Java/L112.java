import java.util.Deque;
import java.util.LinkedList;

public class L112 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 11, 7, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 8, 13, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 4, TreeNode2.NULL_NODE, 1};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(hasPathSum(tree, 22));
    }

    public static boolean hasPathSum(TreeNode2 root, int targetSum) {
        Deque<TreeNode2> stack=new LinkedList<>();

        if (root!=null) stack.push(root);
        while (!stack.isEmpty()){
            TreeNode2 node = stack.peek();
            if (node!=null){
                stack.pop();

                if (node.right!=null) stack.push(node.right);
                if (node.left!=null) stack.push(node.left);

                stack.push(node);
                stack.push(null);
            }else {
                stack.pop();
                node = stack.pop();


            }
        }
        return false;
    }


}
