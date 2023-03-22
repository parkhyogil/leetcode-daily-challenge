class Solution {
    public int minScore(int n, int[][] roads) {
        int[] roots = new int[n + 1];
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            roots[i] = i;
            scores[i] = Integer.MAX_VALUE;
        }


        for (int[] r : roads) {
            int a = r[0];
            int b = r[1];
            int dist = r[2];

            int min = Math.min(r[2], Math.min(scores[findRoot(a, roots)], scores[findRoot(b, roots)]));
            union(a, b, roots);
            scores[findRoot(r[0], roots)] = min;
        }
        return scores[1];
    }

    private void union(int a, int b, int[] roots) {
        a = findRoot(a, roots);
        b = findRoot(b, roots);

        if (a < b) {
            roots[b] = a;
        } else {
            roots[a] = b;
        }
    }

    private int findRoot(int child, int[] roots) {
        if (child == roots[child]) {
            return child;
        }
        return roots[child] = findRoot(roots[child], roots);
    }
}
