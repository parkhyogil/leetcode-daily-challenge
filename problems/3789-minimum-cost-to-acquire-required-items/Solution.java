class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (cost1 + cost2 < costBoth) {
            return (long) cost1 * need1 + (long) cost2 * need2;
        }

        int min = Math.min(need1, need2);

        long result = (long) costBoth * min;

        need1 -= min;
        need2 -= min;

        result += (long) Math.min(cost1, costBoth) * need1 + (long) Math.min(cost2, costBoth) * need2;

        return result;
    }
}
