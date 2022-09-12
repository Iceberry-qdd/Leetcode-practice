import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L652 {
    public static void main(String[] args) {

    }

    static List<TreeNode> result;
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        getSubTree(root, map);
        return result;
    }

    private static String getSubTree(TreeNode root, Map<String, Integer> map) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        String str = String.format("%d %s %s", root.val,
                getSubTree(root.left, map),
                getSubTree(root.right, map));
        if (map.containsKey(str) && map.get(str) == 1) {
            result.add(root);
        }
        map.merge(str, 1, Integer::sum);
        return str;
    }
}
