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
        return recur(0, 0, charCount, target, memo);
    }

    private int recur(int targetIdx, int wordIdx, int[][] charCount, String target, int[][] memo) {
        if (targetIdx == target.length()) {
            return 1;
        }
        if (target.length() - targetIdx > charCount.length - wordIdx) {
            return 0;
        }
        if (memo[targetIdx][wordIdx] != -1) {
            return memo[targetIdx][wordIdx];
        }
        long res = 0;
        for (int i = wordIdx; i < charCount.length; i++) {
            long count = charCount[i][target.charAt(targetIdx) - 'a'];
            if (count > 0) {
                res += count * recur(targetIdx + 1, i + 1, charCount, target, memo);
                res %= MOD;
            }            
        }
        return memo[targetIdx][wordIdx] = (int) res;
    }
}
