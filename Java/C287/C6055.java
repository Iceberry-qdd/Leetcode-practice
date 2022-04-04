package C287;

public class C6055 {
    public static void main(String[] args) {
        String current = "02:30", correct = "04:35";
        int result = convertTime(current, correct);
        System.out.println(result);
    }

    public static int convertTime(String current, String correct) {
        int duration = subTime(current, correct);
        int step = 0;
        if (duration == 0) return step;
        while (duration >= 60) {
            duration -= 60;
            step++;
        }
        while (duration >= 15) {
            duration -= 15;
            step++;
        }
        while (duration >= 5) {
            duration -= 5;
            step++;
        }
        while (duration >= 1) {
            duration -= 1;
            step++;
        }
        return step;
    }

    public static int subTime(String time1, String time2) {
        String[] splitTime1 = time1.split(":");
        String[] splitTime2 = time2.split(":");
        int subHour = Integer.parseInt(splitTime2[0]) - Integer.parseInt(splitTime1[0]);
        int subMin = Integer.parseInt(splitTime2[1]) - Integer.parseInt(splitTime1[1]);
        if (subMin < 0){
            subMin += 60;
            subHour--;
        }
        return subHour * 60 + subMin;
    }
}
