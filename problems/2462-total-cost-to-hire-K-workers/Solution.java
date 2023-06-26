class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int lIdx = 0;
        int rIdx = n - 1;
        for (int i = 0; i < candidates && lIdx <= rIdx; i++) {
            left.offer(costs[lIdx++]);
            if (lIdx < rIdx) {
                right.offer(costs[rIdx--]);
            }
        }

        long res = 0;
        while (k-- > 0){
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                res += left.poll();
                if (lIdx <= rIdx) {
                    left.offer(costs[lIdx++]);
                }
            } else {
                res += right.poll();
                if (lIdx <= rIdx) {
                    right.offer(costs[rIdx--]);
                }
            }
        }        
        return res;
    }
}
