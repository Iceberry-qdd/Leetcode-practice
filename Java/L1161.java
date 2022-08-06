import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class L1161 {
    public static final int NULL=TreeNode2.NULL_NODE;
    public static void main(String[] args) {
        int[] arr=new int[]{1,7,7,NULL,NULL,-8,NULL,NULL,0,NULL,NULL};
        TreeNode2 tree=new TreeNode2(arr).left;
        System.out.println(maxLevelSum(tree));

        arr=new int[]{989,NULL,10250,98693,NULL,NULL,-89388,NULL,-32127};
        tree=new TreeNode2(arr).left;
        System.out.println(maxLevelSum(tree));
    }

    public static int maxLevelSum(TreeNode2 root) {
        Deque<TreeNode2> queue = new ArrayDeque<>();
        int result = Integer.MAX_VALUE, layerMaxSum = Integer.MIN_VALUE, layerNo = 0;

        if (root != null) {
            queue.push(root);
            //result = root.val;
        }

        while (!queue.isEmpty()) {
            layerNo++;
            int size = queue.size(), curLayerSum = 0;
            while (size > 0) {
                TreeNode2 node = queue.getLast();
                queue.pollLast();
                curLayerSum += node.val;
                if (node.left != null) queue.push(node.left);
                if (node.right != null) queue.push(node.right);
                size--;
            }
            if (curLayerSum > layerMaxSum) {
                result = layerNo;
                layerMaxSum = curLayerSum;
            }
        }
        return result;
    }
}
