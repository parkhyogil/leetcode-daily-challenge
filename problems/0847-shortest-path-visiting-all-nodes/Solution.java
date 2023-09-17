class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        int endMask = (1 << n) - 1;

        boolean[][] visit = new boolean[n][1 << n];
        Queue<List<Integer>> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(List.of(i, 1 << i));
            visit[i][1 << i] = true;
        }

        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                List<Integer> curr = q.poll();

                int node = curr.get(0);
                int mask = curr.get(1);

                if (mask == endMask) {
                    return res;
                }

                for (int next : graph[node]) {
                    int nextMask = mask | (1 << next);

                    if (visit[next][nextMask]) {
                        continue;
                    }

                    q.offer(List.of(next, nextMask));
                    visit[next][nextMask] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
