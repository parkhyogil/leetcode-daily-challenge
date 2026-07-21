class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int prev = 0;
        int curr = 0;

        int one = 0;

        int max = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '0') {
                if (i > 0 && c != s.charAt(i - 1)) {
                    prev = curr;
                    curr = 1;
                } else {
                    curr++;
                }
                
                if (prev > 0) {
                    max = Math.max(prev + curr, max);
                }
            } else {
                one++;
            }
        }

        if (prev == 0) {
            return one;
        }

        return max + one;
    }
}
