class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;

        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                in[edges[i]]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (edges[curr] == -1) {
                continue;
            }
            
            in[edges[curr]]--;
            if (in[edges[curr]] == 0) {
                q.offer(edges[curr]);
            }
            edges[curr] = -1;
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                res = Math.max(res, dfs(i, edges));
            }
        }
        return res;
    }

    private int dfs(int node, int[] edges) {
        if (edges[node] == -1) {
            return 0;
        }
        int next = edges[node];
        edges[node] = -1;
        return 1 + dfs(next, edges);
    }
}
