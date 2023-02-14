class Solution {
    private List<List<Integer>> tree;
    private String labels;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        setTree(n, edges);
        this.labels = labels;

        int[] res = new int[n];
        count(0, res, new boolean[n]);
        return res;
    }

    private int[] count(int node, int[] res, boolean[] visit) {
        visit[node] = true;
        int label = labels.charAt(node) - 'a';
        int[] count = new int[26];
        count[label] = 1;
      
        for (int child : tree.get(node)) {
            if (visit[child]) {
                continue;
            }
            int[] childCount = count(child, res, visit);
            mergeCount(count, childCount);
        }
    
        res[node] = count[label];
        return count;
    }

    private void mergeCount(int[] count, int[] childCount) {
        for (int i = 0; i < 26; i++) {
            count[i] += childCount[i];
        }
    }

    private void setTree(int n, int[][] edges) {
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
    }
}
