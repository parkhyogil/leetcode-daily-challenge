class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        PriorityQueue<int[]> sortedProjects = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> sortedProfits = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < n; i++) {
            if (capital[i] <= w) {
                sortedProfits.offer(profits[i]);
            } else {
                sortedProjects.offer(new int[] {profits[i], capital[i]});
            }
        }

        for (int i = 0; i < k && !sortedProfits.isEmpty(); i++) {
            w += sortedProfits.poll();

            while (!sortedProjects.isEmpty() && sortedProjects.peek()[1] <= w) {
                sortedProfits.offer(sortedProjects.poll()[0]);
            }
        }

        return w;
    }
}
