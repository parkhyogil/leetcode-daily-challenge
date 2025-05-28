class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dfs(i, -1, k - 1, tree2));
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = dfs(i, -1, k, tree1) + max;
        }

        return result;
    }

    private int dfs(int node, int parent, int k, List<List<Integer>> tree) {
        if (k < 0) {
            return 0;
        }

        int result = 1;

        for (int child : tree.get(node)) {
            if (child == parent) {
                continue;
            }
            
            result += dfs(child, node, k - 1, tree);
        }

        return result;
    }

    private List<List<Integer>> buildTree(int n, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        return tree;
    }
}
