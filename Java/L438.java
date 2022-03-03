import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("abab", "ababab"));
        System.out.println(findAnagrams("abab", "abab"));
        System.out.println(findAnagrams("a", "a"));
        System.out.println(findAnagrams("a", "ab"));
        System.out.println(findAnagrams("abcbadscada", "dcaa"));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        int lenS=s.length(),lenP=p.length();
        int[] alpha=new int[26];
        for (int i=0;i<lenP;i++) alpha[p.charAt(i) - 'a']++;
        int left=0,right;
        List<Integer> list=new ArrayList<>();
        for (right=0;right<lenS;right++){
            if (alpha[s.charAt(right)-'a']>0){
                alpha[s.charAt(right)-'a']--;
                if (right-left+1==lenP) list.add(left);
            }else{
                alpha[s.charAt(left++)-'a']++;
                right--;
            }
        }
        return  list;
    }

//    public static List<Integer> findAnagrams(String s, String p) {
//        int lenS = s.length(), lenP = p.length();
//        int[] alpha=new int[26];
//        int[] alpha2=new int[26];
//        for (int i=0;i<lenP;i++){
//            alpha[p.charAt(i)-'a']++;
//            alpha2[p.charAt(i)-'a']++;
//        }
//
//        int left=0,right=0;
//        List<Integer> list=new ArrayList<>();
//        for (right=0;right<lenS;right++){
//            if (alpha2[s.charAt(right)-'a']==0){
//                left=right;
//            }else alpha[s.charAt(right)-'a']--;
//
//
//
////            if (alpha[s.charAt(right)-'a']>0){
////                right++;
////            }
//
//            if (alpha[s.charAt(right)-'a']<0){
//                left++;
//            }
//
//            if (alpha[s.charAt(right)-'a']==0 && right-left+1==lenP){
//                list.add(left);
//                alpha=alpha2;
//            }
//
//
//        }
//        return list;
//    }

//    public static List<Integer> findAnagrams(String s, String p) {
//        int lenS = s.length(), lenP = p.length();
//        if (lenP > lenS) return new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        p = sortedString(p);
//        int left = 0, right = lenP;
//        while (right <= lenS) {
//            String curStr = sortedString(s.substring(left, right));
//            if (curStr.equals(p)) list.add(left);
//            left++;
//            right++;
//        }
//        return list;
//    }
//
//    public static String sortedString(String str) {
//        char[] pChs = str.toCharArray();
//        Arrays.sort(pChs);
//        return new String(pChs);
//    }
}
