public class L530 {
    private static final int NULL = TreeNode2.NULL_NODE;

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, NULL, NULL, 3, NULL, NULL, 6};
        TreeNode2 tree = new TreeNode2(arr).left;
        System.out.println(getMinimumDifference(tree));

        arr=new int[]{1,0,NULL,NULL,48,12,NULL,NULL,49};
        tree=new TreeNode2(arr).left;
        System.out.println(getMinimumDifference(tree));
    }

    static TreeNode2 preNode;
    static int result=Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode2 root) {
        traversal(root);
        return result;
    }

    public static void traversal(TreeNode2 root){
        if (root==null) return;

        traversal(root.left);

        if (preNode!=null){
            result=Math.min(result ,root.val- preNode.val);
        }
        preNode=root;

        traversal(root.right);
    }
}
