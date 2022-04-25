public class L868 {
    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(8));
        System.out.println(binaryGap(5));
    }

    public static int binaryGap(int n) {
        int startPos, endPos = -1, result = 0;
        for (int i = 0; n >> i > 0; i++) {
            int curBitValue = (n >> i) & 1;
            if (curBitValue == 0) continue;

            startPos = endPos;
            endPos = i;

            if (startPos != -1 && endPos != -1) {
                result = Math.max(result, endPos - startPos);
            }
        }
        return result;
    }
}
