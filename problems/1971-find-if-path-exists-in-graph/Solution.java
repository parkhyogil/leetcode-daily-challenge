class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], root);
        }

        return getRoot(source, root) == getRoot(destination, root);
    }

    private void union(int a, int b, int[] root) {
        a = getRoot(a, root);
        b = getRoot(b, root);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    private int getRoot(int child, int[] root) {
        if (child == root[child]) {
            return child;
        }
        return root[child] = getRoot(root[child], root);
    }
}