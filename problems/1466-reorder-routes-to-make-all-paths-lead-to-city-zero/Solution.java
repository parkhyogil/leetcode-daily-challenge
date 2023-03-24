class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            graph.get(c[0]).add(-c[1]);
            graph.get(c[1]).add(c[0]);
        }

        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        q.offer(0);
        visit[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph.get(curr)) {
                int abs = Math.abs(next);
                if (visit[abs]) {
                    continue;
                }
                if (next < 0) {
                    res++;
                }
                q.offer(abs);
                visit[abs] = true;
            }
        }
        return res;
    }
}
