class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        int[] depth = new int[n];

        int odd = dfs(0, 0, -1, depth, tree1);
        int even = n - odd;
        
        int max = dfs(0, 0, -1, new int[m], tree2);
        max = Math.max(max, m - max);
        
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = max + (depth[i] % 2 == 0 ? even : odd);
        }

        return result;
    }
    
    private int dfs(int d, int node, int parent, int[] depth, List<List<Integer>> tree) {
        int result = d % 2;
        depth[node] = d;

        for (int child : tree.get(node)) {
            if (child == parent) {
                continue;
            }
            result += dfs(d + 1, child, node, depth, tree);
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
