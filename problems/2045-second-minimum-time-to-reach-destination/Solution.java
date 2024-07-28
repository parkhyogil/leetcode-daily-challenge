class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = makeGraph(n, edges);

        Queue<Integer> queue = new LinkedList<>();

        int[] visitCount = new int[n];
        int[] distance = new int[n];

        queue.offer(0);
        visitCount[0] = 1;

        int res = 0;
        while (!queue.isEmpty() && visitCount[n - 1] < 2) {
            int size = queue.size();

            if ((res / change) % 2 == 1) {
                res = change * ((res + change) / change);
            }

            res += time;

            while (size-- > 0) {
                int node = queue.poll();

                for (int next : graph.get(node)) {
                    if (res > distance[next] && visitCount[next] < 2) {
                        distance[next] = res;
                        visitCount[next]++;
                        queue.offer(next);
                    }
                }
            }
        }

        return res;
    }

    private List<List<Integer>> makeGraph(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            res.get(u).add(v);
            res.get(v).add(u);
        }

        return res;
    }
}
