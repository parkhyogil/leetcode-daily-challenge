class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        int[][] count = new int[n][26];
        boolean[] visit = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                visit[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            int color = colors.charAt(node) - 'a';
            count[node][color]++;

            for (int next : graph.get(node)) {
                indegree[next]--;
                for (int i = 0; i < 26; i++) {
                    count[next][i] = Math.max(count[next][i], count[node][i]);
                }
                if (indegree[next] == 0) {
                    q.offer(next);
                    visit[next] = true;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                return -1;
            }
            for (int j = 0; j < 26; j++) {
                res = Math.max(res, count[i][j]);
            }
        }
        return res;
    }
}
