class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] roots = new int[n];
        int[] sizes = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            sizes[i] = 1;
        }

        for (int[] e : edges) {
            union(e[0], e[1], roots, sizes);
        }

        long res = 0;
        long nodes = n;
        for (int i = 0; i < n; i++) {
            if (i != findRoot(i, roots)) {
                continue;
            }
            nodes -= sizes[i];
            res += nodes * sizes[i];
        }
        return res;
    }

    private void union(int a, int b, int[] roots, int[] sizes) {
        a = findRoot(a, roots);
        b = findRoot(b, roots);

        if (a == b) {
            return;
        }

        if (a < b) {
            roots[b] = a;
            sizes[a] += sizes[b];
        } else {
            roots[a] = b;
            sizes[b] += sizes[a];
        }
    }

    private int findRoot(int child, int[] roots) {
        if (child == roots[child]) {
            return child;
        }
        return roots[child] = findRoot(roots[child], roots);
    }
}
