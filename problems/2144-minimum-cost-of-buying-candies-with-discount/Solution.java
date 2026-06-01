class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;

        Arrays.sort(cost);
        int result = 0;

        for (int i = n - 1; i >= 0; i -= 3) {
            result += cost[i];
            if (i > 0) {
                result += cost[i - 1];
            }
        }

        return result;
    }
}
