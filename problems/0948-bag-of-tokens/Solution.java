class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;

        Arrays.sort(tokens);

        int score = 0;

        for (int i = 0, j = n - 1; i <= j;) {
            if (power >= tokens[i]) {
                score++;
                power -= tokens[i++];
            } else if (score > 0 && i < j) {
                score--;
                power += tokens[j--];
            } else {
                break;
            }
        }

        return score;
    }
}
