class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();

        int[] count = new int[128];

        int res = 0;
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]--;
            count[t.charAt(i)]++;
        }

        for (int c : count) {
            if (c > 0) {
                res += c;
            }
        }

        return res;
    }
}
