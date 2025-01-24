class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Integer> result = new ArrayList<>();

        int[] isChecked = new int[n];

        for (int i = 0; i < n; i++) {
            if (isSafeNode(i, graph, isChecked)) {
                result.add(i);
            }
        }

        return result;
    }

    boolean isSafeNode(int node, int[][] graph, int[] isChecked) {
        if (graph[node].length == 0) {
            return true;
        }

        if (isChecked[node] != 0) {
            return isChecked[node] == 1;
        }

        isChecked[node] = -1;
        
        for (int adjacentNode : graph[node]) {
            if (!isSafeNode(adjacentNode, graph, isChecked)) {
                return false;
            }
        }

        isChecked[node] = 1;
        return true;
    }
}
