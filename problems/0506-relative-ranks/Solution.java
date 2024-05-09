class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(score[b], score[a]));
        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }

        String[] res = new String[n];

        res[pq.poll()] = "Gold Medal";
        if (n >= 2) {
            res[pq.poll()] = "Silver Medal";
        }
        if (n >= 3) {
            res[pq.poll()] = "Bronze Medal";
        }
        
        for (int i = 4; i <= n; i++) {
            res[pq.poll()] = String.valueOf(i);
        }

        return res;
    }
}
