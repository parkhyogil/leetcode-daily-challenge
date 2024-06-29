class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = makeGraph(n, edges);
        int[] indegree = countIndegree(n, edges);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Set<Integer>> ancestorSets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ancestorSets.add(new HashSet<>());
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int node = queue.poll();

                for (int next : graph.get(node)) {
                    ancestorSets.get(next).add(node);
                    ancestorSets.get(next).addAll(ancestorSets.get(node));

                    indegree[next]--;

                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ancestorSets.get(i));
            Collections.sort(list);
            res.add(list);
        }

        return res;
    }

    private int[] countIndegree(int n, int[][] edges) {
        int[] res = new int[n];

        for (int[] edge : edges) {
            res[edge[1]]++;
        }

        return res;
    }

    private List<List<Integer>> makeGraph(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            res.get(edge[0]).add(edge[1]);
        }

        return res;
    }
}
