class Solution {
    int n;
    int[] indegree;
    List<List<int[]>> graph;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;

        graph = new ArrayList<>();
        indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            if (online[u] && online[v]) {
                graph.get(u).add(e);
                indegree[v]++;
            }
        }

        int lo = Integer.MAX_VALUE;
        int hi = 0;

        for (int[] e : edges) {
            lo = Math.min(lo, e[2]);
            hi = Math.max(hi, e[2]);
        }

        if (!decide(0, k)) {
            return -1;
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(mid, k)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    boolean decide(int t, long k) {
        Queue<Integer> queue = new ArrayDeque<>();
        long[] total = new long[n];

        for (int i = 0; i < n; i++) {
            total[i] = k + 1;
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        total[0] = 0;
        int[] count = new int[n];

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int[] e : graph.get(u)) {
                int v = e[1], c = e[2];

                count[v]++;

                if (c >= t) {
                    total[v] = Math.min(total[v], total[u] + c);
                }

                if (indegree[v] == count[v]) {
                    queue.offer(v);
                }
            }
        }

        return total[n - 1] <= k;
    }
}
