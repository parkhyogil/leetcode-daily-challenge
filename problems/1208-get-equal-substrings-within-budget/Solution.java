class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();

        int cost = 0;
        int res = 0;

        for (int l = 0, r = 0; r < n; r++) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));

            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
