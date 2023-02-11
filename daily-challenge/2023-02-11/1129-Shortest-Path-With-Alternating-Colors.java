class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> red = new ArrayList<>();
        List<List<Integer>> blue = new ArrayList<>();
        boolean[][] visit = new boolean[n][2];

        for (int i = 0; i < n; i++) {
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }

        for (int[] e : redEdges) {
            red.get(e[0]).add(e[1]);
        }

        for (int[] e : blueEdges) {
            blue.get(e[0]).add(e[1]);
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});
        q.offer(new int[] {0, 0, 1});
        visit[0][0] = visit[0][1] = true;
        res[0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int node = cur[0];
            int dist = cur[1];
            int color = cur[2];

            List<Integer> adjacent = color == 0 ? red.get(node) : blue.get(node);

            for (int next : adjacent) {
                if (visit[next][color]) {
                    continue;
                }

                q.offer(new int[] {next, dist + 1, color ^ 1});
                visit[next][color] = true;
                if (res[next] == -1) {
                    res[next] = dist + 1;
                } else {
                    res[next] = Math.min(res[next], dist + 1);
                }
            }
        }

        return res;
    }
}
