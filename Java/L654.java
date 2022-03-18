import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class L654 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode2 tree = constructMaximumBinaryTree(nums);
        System.out.println(tree);
    }

    public static TreeNode2 constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;

        TreeNode2 root = new TreeNode2();
        createTree(root, nums, 0, len);
        return root;
    }

    // 左闭右开 [start, end)
    public static void createTree(TreeNode2 tree, int[] nums, int start, int end) {
        int len = end - start;
        if (len <= 0) return;

        int maxIndex = maxIndex(nums, start, end);
        tree.val = nums[maxIndex];

        if (maxIndex - start > 0) {
            tree.left = new TreeNode2();
            createTree(tree.left, nums, start, maxIndex);
        }

        if (end - maxIndex - 1 > 0) {
            tree.right = new TreeNode2();
            createTree(tree.right, nums, maxIndex + 1, end);
        }
    }

    // 查找最大值所在下标
    public static int maxIndex(int[] nums, int start, int end) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
