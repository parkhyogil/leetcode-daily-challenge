class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> graph = buildGraph(n, meetings);

        List<Integer> result = new ArrayList<>();

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        queue.offer(new int[] {0, 0});
        queue.offer(new int[] {firstPerson, 0});
        minTime[0] = minTime[firstPerson] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int i = curr[0], t = curr[1];

            if (t > minTime[i]) {
                continue;
            }

            result.add(i);

            for (int[] e : graph.get(i)) {
                if (e[1] < t) {
                    continue;
                }

                if (e[1] < minTime[e[0]]) {
                    minTime[e[0]] = e[1];
                    queue.offer(e);
                }
            }
        }

        return result;
    }

    List<List<int[]>> buildGraph(int n, int[][] edges) {
        List<List<int[]>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];

            result.get(u).add(new int[] {v, t});
            result.get(v).add(new int[] {u, t});
        }

        return result;
    }
}
