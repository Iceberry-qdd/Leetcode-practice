public class L904 {
    public static void main(String[] args) {
        //int[] fruits = {1,0,1,4,1,4,1,2,3};
        //int[] fruits={0,1,2,2};
        //int[] fruits={1,2,1};
        int[] fruits={1,2,3,2,2};
        //int[] fruits={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int maxCount = 0, len = fruits.length, left = 0, type = 1;
        int[] types = {-1, -1, -1};//三种类型的水果
//        if (len==1) return 1;
        if (len == 0) return 0;
        for (int right = 0; right < len; right++) {
            types[0] = fruits[left];
            types[1] = types[2];
            if (fruits[right] != types[0] && fruits[right] != types[1]) {
                type++;
                types[2] = fruits[right];
            }
            if (type > 2) {
                left = right - 1;
                while (fruits[left - 1] == fruits[right-1]) left--;
                type--;
            }
            maxCount = Math.max(right - left + 1, maxCount);
        }
        return maxCount;
    }
}
