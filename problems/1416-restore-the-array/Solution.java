class Solution {
    private final int MOD = (int) 1e9 + 7;
    
    public int numberOfArrays(String s, int k) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return recur(0, s, k, memo);
    }

    private int recur(int idx, String s, int k, int[] memo) {
        if (idx == s.length()) {
            return 1;
        }
        if (s.charAt(idx) == '0') {
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }

        int res = 0;
        long num = 0;
        for (int i = idx; i < s.length(); i++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num <= k) {
                res = (res % MOD + recur(i + 1, s, k, memo) % MOD) % MOD;
            } else {
                break;
            }
        }
        return memo[idx] = res;
    }
}
