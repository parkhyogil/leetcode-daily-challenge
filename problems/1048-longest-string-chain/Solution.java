class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        List<Integer>[] wordsByLength = new ArrayList[17];
        for (int i = 0; i <= 16; i++) {
            wordsByLength[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            wordsByLength[words[i].length()].add(i);
        }

        int[] dp = new int[n];
        int res = 0;
        for (int len = 1; len <= 16; len++) {
            for (int i : wordsByLength[len]) {
                dp[i] = 1;

                for (int j : wordsByLength[len - 1]) {
                    if (isPredecessor(words[j], words[i])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    private boolean isPredecessor(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenB - lenA != 1) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < lenA && j < lenB) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return j - i <= 1;
    }
}
