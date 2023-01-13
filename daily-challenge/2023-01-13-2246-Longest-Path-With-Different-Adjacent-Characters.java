class Solution {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> tree = setTree(n, parent);
        int[] pathLen = new int[n];
        return dfs(0, tree, pathLen, s.toCharArray());
    }

    private int dfs(int node, List<List<Integer>> tree, int[] pathLen, char[] chars) {
        int res = 1;
        pathLen[node] = 1;
        for (int child : tree.get(node)) {
            res = Math.max(res, dfs(child, tree, pathLen, chars));
            if (chars[node] == chars[child]) {
                continue;
            }

            res = Math.max(res, pathLen[node] + pathLen[child]);
            pathLen[node] = Math.max(pathLen[node], pathLen[child] + 1);
        }
        return res;
    }

    private List<List<Integer>> setTree(int n, int[] parent) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            res.get(parent[i]).add(i);
        }
        return res;
    }
}
