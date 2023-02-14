class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        if (n == 1) {
            return 1;
        }
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.computeIfAbsent(e[0], v -> new ArrayList<>()).add(e[1]);
            adj.computeIfAbsent(e[1], v -> new ArrayList<>()).add(e[0]);
        }

        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            valuesToNodes.computeIfAbsent(vals[i], v -> new ArrayList<>()).add(i);
            roots[i] = i;
        }

        int res = 0;
        for (int value : valuesToNodes.keySet()) {
            for (int node : valuesToNodes.get(value)) {
                for (int neighbor : adj.get(node)) {
                    if (vals[node] >= vals[neighbor]) {
                        union(node, neighbor, roots);
                    }
                }
            }

            Map<Integer, Integer> group = new HashMap<>();
            for (int u : valuesToNodes.get(value)) {
                int root = getRoot(u, roots);
                group.put(root, group.getOrDefault(root, 0) + 1);
            }

            for (int size : group.values()) {
                res += size * (size + 1) / 2;
            }
        }
        return res;
    }

    private void union(int a, int b, int[] roots) {
        a = getRoot(a, roots);
        b = getRoot(b, roots);

        if (a == b) {
            return;
        }

        if (a < b) {
            roots[b] = a;
        } else {
            roots[a] = b;
        }
    }
    private int getRoot(int node, int[] roots) {
        if (roots[node] == node) {
            return node;
        }
        return roots[node] = getRoot(roots[node], roots);
    }
}
