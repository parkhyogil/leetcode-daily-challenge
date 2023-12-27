class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();

        int sum = 0;
        int max = 0;

        int res = 0;
        for (int l = 0, r = 0; r < n; r++) {
            sum += neededTime[r];
            max = Math.max(max, neededTime[r]);

            if (r + 1 == n || colors.charAt(l) != colors.charAt(r + 1)) {
                res += sum - max;

                sum = 0;
                max = 0;
                l = r + 1;
            }
        }

        return res;
    }
}
