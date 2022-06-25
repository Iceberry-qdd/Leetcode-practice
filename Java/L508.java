import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L508 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {5, 2, NULL, NULL, -3};
        TreeNode2 tree = new TreeNode2(arr).left;
        int[] result = findFrequentTreeSum(tree);
        System.out.println(Arrays.toString(result));

        arr = new int[]{5, 2, NULL, NULL, -5};
        tree = new TreeNode2(arr).left;
        result = findFrequentTreeSum(tree);
        System.out.println(Arrays.toString(result));
    }

    private static final Map<Integer, Integer> map = new HashMap<>();
    private static int maxCount = Integer.MIN_VALUE;

    public static int[] findFrequentTreeSum(TreeNode2 root) {
        dfs(root);
        int len = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) len++;
        }

        int[] result = new int[len];
        int i = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) result[i++] = key;
        }
        return result;
    }

    public static int dfs(TreeNode2 root) {
        if (root == null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int curSum = root.val + leftSum + rightSum;
        map.merge(curSum, 1, Integer::sum);
        maxCount = Math.max(maxCount, map.get(curSum));
        return curSum;
    }
}
