class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();

        int result = 0;

        for (int i = 0; i < n; i++) {
            int j = i;

            int sum = 0, max = 0;

            while (j < n && colors.charAt(i) == colors.charAt(j)) {
                sum += neededTime[j];
                max = Math.max(max, neededTime[j]);
                j++;
            }

            i = j - 1;
            result += sum - max;
        }

        return result;
    }
}
