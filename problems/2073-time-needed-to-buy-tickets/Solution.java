class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;

        int max = tickets[k];

        int res = 0;

        for (int i = 0; i <= k; i++) {
            res += Math.min(tickets[i], max);
        }
        for (int i = k + 1; i < n; i++) {
            res += Math.min(tickets[i], max - 1);
        }

        return res;
    }
}
