class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        List<List<Integer>> graph= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (canAffect(bombs[i], bombs[j])) {
                    graph.get(i).add(j);
                }
                if (canAffect(bombs[j], bombs[i])) {
                    graph.get(j).add(i);
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, graph, new boolean[n]));
            if (res == n) {
                return res;
            }
        }
        return res;
    }

    private int dfs(int node, List<List<Integer>> graph, boolean[] visit) {
        if (visit[node]) {
            return 0;
        }
        int res = 1;
        visit[node] = true;
        for (int next : graph.get(node)) {
            res += dfs(next, graph, visit);
        }
        return res;
    }

    private boolean canAffect(int[] a, int[] b) {
        long r = a[2];
        long dx = a[0] - b[0];
        long dy = a[1] - b[1];

        return r * r >= dx * dx + dy * dy;
    }
}
