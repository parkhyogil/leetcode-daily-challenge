class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if ((i % 2 == 0 && c == '1') || i % 2 == 1 && c == '0') {
                res++;
            }
        }

        return Math.min(res, n - res);
    }
}
