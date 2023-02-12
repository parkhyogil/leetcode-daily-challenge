class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            tree.get(r[0]).add(r[1]);
            tree.get(r[1]).add(r[0]);
        }

        int[] numOfSubtreeNodes = new int[n];
        dfs(0, -1, tree, numOfSubtreeNodes);

        long res = 0;
        for (int i = 1; i < n; i++) {
            res += (numOfSubtreeNodes[i] + seats - 1) / seats;
        }
        return res;
    }

    private void dfs(int node, int parent, List<List<Integer>> tree, int[] numOfSubtreeNodes) {
        numOfSubtreeNodes[node] = 1;
        for (int child : tree.get(node)) {
            if (child == parent) {
                continue;
            }
            dfs(child, node, tree, numOfSubtreeNodes);
            numOfSubtreeNodes[node] += numOfSubtreeNodes[child];
        }
    }
}
