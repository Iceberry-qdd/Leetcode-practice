public class L1450 {
    public static void main(String[] args) {

    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length, result = 0;
        for (int i = 0; i < len; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                result++;
            }
        }
        return result;
    }
}
