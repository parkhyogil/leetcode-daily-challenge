class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();

        int res = 0;
        int trueCount = 0;
        int falseCount = 0;
        for (int l = 0, r = 0; r < n; r++) {
            char c = answerKey.charAt(r);

            if (c == 'T') {
                trueCount++;
            } else {
                falseCount++;
            }

            while (Math.min(trueCount, falseCount) > k) {
                c = answerKey.charAt(l++);

                if (c == 'T') {
                    trueCount--;
                } else {
                    falseCount--;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
