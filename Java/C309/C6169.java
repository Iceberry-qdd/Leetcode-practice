//package C309;
//
//public class C6169 {
//    public static void main(String[] args) {
//        System.out.println(longestNiceSubarray(new int[]{1,3,8,48,10}));
//        System.out.println(longestNiceSubarray(new int[]{744437702,379056602,145555074,392756761,560864007,934981918,113312475,1090,16384,33,217313281,117883195,978927664}));
//    }
//
//    public static int longestNiceSubarray(int[] nums) {
//        int[] len=
//        int len = nums.length, maxLen = 1;
//        for (int i = 0; i < len-1; i++) {
//            int curLen=1;
////            System.out.printf("%d ",nums[i] & nums[j]);
//            for (int j = i; j < len-1; j++) {
//                for (int k = j+1; k < len; k++) {
//                    if ((nums[j] & nums[k]) == 0) {
//                        curLen=k-j+1;
//                    } else {
//                        curLen=Math.min(curLen,k-j);
//                        //curLen=j;
//                        i=j;
//                    break;
//                    }
//                }
//
//            }
//            maxLen = Math.max(maxLen, curLen);
//        }
//        return maxLen;
//    }
//}
