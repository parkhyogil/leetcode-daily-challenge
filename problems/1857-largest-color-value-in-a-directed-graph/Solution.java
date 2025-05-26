class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        List<List<Integer>> graph = buildGraph(n, edges);
        int[][] count = new int[n][26];

        boolean[] visited = new boolean[n];
        boolean[] checking = new boolean[n];

        int maxColor = 0;

        for (int i = 0; i < n; i++) {
            if (dfs(i, colors, graph, count, visited, checking)) {
                return -1;
            }

            maxColor = Math.max(maxColor, count[i][colors.charAt(i) - 'a']);
        }

        return maxColor;
    }

    private boolean dfs(int node, String colors, List<List<Integer>> graph, int[][] count, boolean[] visited, boolean[] checking) {
        if (checking[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }
        
        visited[node] = true;
        checking[node] = true;

        for (int next : graph.get(node)) {
            if (dfs(next, colors, graph, count, visited, checking)) {
                return true;
            }

            for (int i = 0; i < 26; i++) {
                count[node][i] = Math.max(count[node][i], count[next][i]);
            }
        }

        count[node][colors.charAt(node) - 'a']++;
        
        checking[node] = false;

        return false;
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }
        
        return graph;
    }
}
