class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;

        int[][] players = new int[n][];
        for (int i = 0; i < n; i++) {
            players[i] = new int[] {ages[i], scores[i]};
        }

        Arrays.sort(players, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (players[i][1] >= players[j][1]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + players[i][1];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
