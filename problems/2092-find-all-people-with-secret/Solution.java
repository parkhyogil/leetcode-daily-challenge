class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new int[] {firstPerson, 0});

        for (int[] meeting : meetings) {
            graph.get(meeting[0]).add(new int[] {meeting[1], meeting[2]});
            graph.get(meeting[1]).add(new int[] {meeting[0], meeting[2]});
        }

        int[] meetTime = new int[n];
        Arrays.fill(meetTime, Integer.MAX_VALUE);

        dfs(0, 0, graph, meetTime);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (meetTime[i] != Integer.MAX_VALUE) {
                res.add(i);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int node, int time, List<List<int[]>> graph, int[] meetTime) {
        meetTime[node] = time;

        for (int[] next : graph.get(node)) {
            int nextNode = next[0];
            int nextTime = next[1];

            if (nextTime < time || nextTime >= meetTime[nextNode]) {
                continue;
            }

            dfs(nextNode, nextTime, graph, meetTime);
        }
    }
}
