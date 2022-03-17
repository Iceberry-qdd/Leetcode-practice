public class L572 {
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 1, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 5};
        int[] arr2 = {4, 1, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2};
        TreeNode2 tree1 = new TreeNode2(arr1).left;
        TreeNode2 tree2 = new TreeNode2(arr2).left;

        long startTime = System.currentTimeMillis();
        boolean result = isSubtree(tree1, tree2);
        long endTime = System.currentTimeMillis();

        System.out.println(result);
        System.out.printf("执行耗时%dms\n", endTime - startTime);

        arr1 = new int[]{3, 4, 1, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2, 0, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 5};
        arr2 = new int[]{4, 1, TreeNode2.NULL_NODE, TreeNode2.NULL_NODE, 2};
        tree1 = new TreeNode2(arr1).left;
        tree2 = new TreeNode2(arr2).left;

        startTime = System.currentTimeMillis();
        result = isSubtree(tree1, tree2);
        endTime = System.currentTimeMillis();

        System.out.println(result);
        System.out.printf("执行耗时%dms\n", endTime - startTime);

        arr1 = new int[]{1, 1};
        arr2 = new int[]{1};
        tree1 = new TreeNode2(arr1).left;
        tree2 = new TreeNode2(arr2).left;

        startTime = System.currentTimeMillis();
        result = isSubtree(tree1, tree2);
        endTime = System.currentTimeMillis();

        System.out.println(result);
        System.out.printf("执行耗时%dms\n", endTime - startTime);

    }

    public static boolean isSubtree(TreeNode2 root, TreeNode2 subRoot) {
        if (root == null) return false;
        else if (subRoot == null) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSame(root, subRoot);

    }

    public static boolean isSame(TreeNode2 root1, TreeNode2 root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        else if (root1.val != root2.val) return false;

        boolean isLeftSame = isSame(root1.left, root2.left);
        boolean isRightSame = isSame(root1.right, root2.right);
        return isLeftSame && isRightSame;
    }
}
