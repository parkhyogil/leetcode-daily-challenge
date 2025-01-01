class Solution {
    public int maxScore(String s) {
        int n = s.length();

        int zero = 0;
        int one = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                one++;
            }
        }

        int score = 0;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one--;
            }

            score = Math.max(score, zero + one);
        }

        return score;
    }
}
