public class L1629 {
    public static void main(String[] args) {

    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int rLen = releaseTimes.length, index = 0, maxTime = releaseTimes[0];
        for (int i = 1; i < rLen; i++) {
            int curTime = releaseTimes[i] - releaseTimes[i - 1];
            if (curTime > maxTime) {
                index = i;
                maxTime = curTime;
            } else if (curTime == maxTime && keysPressed.charAt(i) > keysPressed.charAt(index)) {
                index = i;
            }
        }
        return keysPressed.charAt(index);
    }
}
