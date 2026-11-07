class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        int[] free = new int[n];
        PriorityQueue<Integer> f = new PriorityQueue<>((a, b) -> servers[a] == servers[b] ? a - b : servers[a] - servers[b]);
        PriorityQueue<Integer> w = new PriorityQueue<>((a, b) -> free[a] - free[b]);

        for (int i = 0; i < n; i++) {
            f.offer(i);
        }

        int[] result = new int[m];

        int t = 0;

        for (int i = 0; i < m; i++) {
            if (f.isEmpty()) {
                t = free[w.peek()];
            }

            while (!w.isEmpty() && t >= free[w.peek()]) {
                f.offer(w.poll());
            }

            int s = f.poll();

            result[i] = s;
            free[s] = t + tasks[i];
            w.offer(s);

            if (t == i) {
                t++;
            }
        }

        return result;
    }
}
