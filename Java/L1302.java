public class L1302 {
    public static void main(String[] args) {

    }

    static int level=0;
    static int max=0;
    public static int deepestLeavesSum(TreeNode root) {
        dfs(root,level);
        return max;
    }

    public static void dfs(TreeNode root,int deep){
        if (root==null) return;
        if (root.left==null && root.right==null){
            if (deep>level){
                level=deep;
                max=0;
            }else if (deep==level){
                max+=root.val;
            }
            return;
        }
        dfs(root.left,deep+1);
        dfs(root.right,deep+1);
    }
}
