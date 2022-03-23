public class L2038 {
    public static void main(String[] args) {
        String colors = "AAABABB";
        System.out.println(winnerOfGame(colors));
    }

    public static boolean winnerOfGame(String colors) {
        char[] colorsArr = colors.toCharArray();
        int AWinCount = 0, BWinCount = 0, len = colorsArr.length;
        for (int i = 1; i < len - 1; i++) {
            if (colorsArr[i - 1] == 'A' && colorsArr[i] == 'A' && colorsArr[i + 1] == 'A') AWinCount++;
            if (colorsArr[i - 1] == 'B' && colorsArr[i] == 'B' && colorsArr[i + 1] == 'B') BWinCount++;
        }
        return AWinCount > BWinCount;
    }
}
