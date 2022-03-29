public class L2024 {
    public static void main(String[] args) {
        String answerKey = "TTFF";
        int k = 2;
        System.out.println(maxConsecutiveAnswers(answerKey, k));

        System.out.println(maxConsecutiveAnswers("TFFT", 1));
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int maxFCount = getMaxCount(answerKey, 'T', k);
        int maxTCount = getMaxCount(answerKey, 'F', k);
        return Math.max(maxFCount, maxTCount);
    }

    public static int getMaxCount(String answerKey, char key, int k) {
        int len = answerKey.length();
        int left = 0, diffCount = 0, result = 0;
        for (int right = 0; right < len; right++) {
            if (answerKey.charAt(right) == key) {
                diffCount++;
            }

            while (diffCount > k) {
                if (answerKey.charAt(left) == key) {
                    diffCount--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}
