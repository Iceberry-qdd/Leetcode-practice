import java.util.*;

//class DictNode {
//    Set<Character> value;
//    DictNode[] childNode;
//
//    DictNode() {
//        value = new HashSet<>(26);
//        childNode = new DictNode[26];
//    }
//
//    DictNode(char ch) {
//        value = new HashSet<>(26);
//        childNode = new DictNode[26];
//        this.value.add(ch);
//        this.childNode = null;
//    }
//
//    public void insertWord(char[] word) {
//        DictNode head = this;
//        int len = word.length;
//        for (int i = 0; i < len - 1; i++) {
//            head.value.add(word[i]);
//            head.childNode[word[i] % 26] = new DictNode(word[i + 1]);
//            head = head.childNode[word[i] % 26];
//        }
//    }
//
//
//}

public class L720 {
    public static void main(String[] args) {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        System.out.println(longestWord(words));

        words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));

        words = new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
        System.out.println(longestWord(words));

        words = new String[]{"m", "ma", "mat", "math", "s", "sc", "sci", "scie", "scien", "scienc", "science", "a", "ar", "art"};
        System.out.println(longestWord(words));

        words = new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(longestWord(words));

        words = new String[]{"yy","yy"};
        System.out.println(longestWord(words));

        words = new String[]{"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        System.out.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        int len=words.length;
        if (len==1) return words[0];

        Arrays.sort(words);

        Set<String> set=new HashSet<>();
        String result="";
        for (int i = 0; i < len; i++) {
            String subWord = words[i].substring(0, words[i].length() - 1);
            if (words[i].length()==1 || set.contains(subWord)){
                result=words[i].length()>result.length()?words[i]:result;
                set.add(words[i]);
            }
        }
        return result;
    }

//    public static String longestWord(String[] words) {
//        int len = words.length;
//        if (len == 1) return words[0];
//
//        Arrays.sort(words);
//        String result = "", lastResult = "";
//        Set<String> set=new HashSet<>();
//        for (int i = 0,j=0; i < len; i++) {
//            while (i<len-1 && (words[i].length()>1 && words[i].charAt(0)==words[i+1].charAt(0))){
//                set.add(words[i]);
//                i++;
//            }
//
//            String subWord = "";
//            if (i<len-1){
//                 subWord= words[i + 1].substring(0, words[i + 1].length() - 1);
//            }
//            while (i < len - 1 &&(subWord.equals(words[i])|| set.contains(subWord))) {
//                result = words[i + 1];
//                set.add(words[i]);
//                i++;
//            }
//            set.add(words[i]);
//            if (result.length() > lastResult.length()) {
//                lastResult = result;
//            }
//        }
//        return lastResult;
//    }
}
