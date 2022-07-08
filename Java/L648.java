import java.util.List;

class TrieTree {
    TrieTree[] child;
    boolean isEnd;

    public TrieTree() {
        child = new TrieTree[26];
    }
}

public class L648 {
    public static void main(String[] args) {
        List<String> dict = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));

        dict = List.of("a", "b", "c");
        sentence = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(dict, sentence));
    }

    static TrieTree root = new TrieTree();

    public static void insert(String word) {
        TrieTree node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieTree();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    public static int search(String word) {
        TrieTree node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (node==null) return -1;
            if (node.child[index] == null && i == 0) {
                return -1;
            }
            node = node.child[index];
            if (node!=null&&node.isEnd == true) return i;
        }

        return len - 1;
    }

//    public boolean startWith(String prefix){
//        TrieTree node=root;
//        int len=prefix.length();
//        for (int i = 0; i < len; i++) {
//            int index=prefix.charAt(i)-'a';
//            if (node.child[index]==null){
//                return false;
//            }
//            node=node.child[index];
//        }
//        return true;
//    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        int len = dictionary.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            insert(dictionary.get(i));
        }

        String[] words = sentence.split(" ");
        for (String word : words) {
            int index = search(word);
            if (index == -1) {
                sb.append(word).append(' ');
            } else {
                String item = word.substring(0, index+1);
                sb.append(item).append(' ');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
