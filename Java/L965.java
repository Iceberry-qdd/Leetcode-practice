import java.util.HashSet;
import java.util.Set;

public class L965 {
    public static void main(String[] args) {

    }

    int value = -1;
    boolean result = true;

    public boolean isUnivalTree(TreeNode root) {
        value = root.val;
        dfs(root);
        return result;
    }


    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val != value) {
            result = false;
            return;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
