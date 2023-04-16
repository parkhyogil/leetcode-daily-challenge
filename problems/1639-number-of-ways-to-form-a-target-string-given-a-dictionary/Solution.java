class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int n = target.length();
        int m = words[0].length();

        int[][] charCount = new int[m][26];
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                charCount[i][word.charAt(i) - 'a']++;
            }
        }

        int[][] memo = new int[n][m];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return recur(n - 1, m - 1, charCount, target, memo);
    }

    private int recur(int targetIdx, int wordIdx, int[][] charCount, String target, int[][] memo) {
        if (targetIdx < 0) {
            return 1;
        }
        if (targetIdx > wordIdx) {
            return 0;
        }
        if (memo[targetIdx][wordIdx] != -1) {
            return memo[targetIdx][wordIdx];
        }
        long res = recur(targetIdx, wordIdx - 1, charCount, target, memo);
        long count = charCount[wordIdx][target.charAt(targetIdx) - 'a'];
        if (count > 0) {
            res += count * recur(targetIdx - 1, wordIdx - 1, charCount, target, memo);
            res %= MOD;
        }            
        return memo[targetIdx][wordIdx] = (int) res;
    }
}
