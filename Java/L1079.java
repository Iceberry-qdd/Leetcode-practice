import java.util.HashSet;
import java.util.Set;

public class L1079 {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
    }


    static Set<String> set = new HashSet<>();

    public static int numTilePossibilities(String tiles) {
        backTracing(tiles, new boolean[tiles.length()], new StringBuilder());
        return set.size() - 1;
    }

    public static void backTracing(String tiles, boolean[] visited, StringBuilder sb) {
        int len = tiles.length();
        set.add(sb.toString());

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(tiles.charAt(i));
                backTracing(tiles, visited, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
