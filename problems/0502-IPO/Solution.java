class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }
        
        Arrays.sort(projects, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int idx = 0;
        while (idx < n && w >= projects[idx][1]) {
            pq.offer(projects[idx++][0]);
        }
        while (!pq.isEmpty() && k-- > 0) {
            w += pq.poll();
            while (idx < n && w >= projects[idx][1]) {
                pq.offer(projects[idx++][0]);
            }
        }
        return w;
    }
}
