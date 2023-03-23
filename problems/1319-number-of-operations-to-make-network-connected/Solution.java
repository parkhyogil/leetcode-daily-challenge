class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        int group = n;
        int extractedCables = 0;
        for (int[] c : connections) {
            if (findRoot(c[0], roots) != findRoot(c[1], roots)) {
                union(c[0], c[1], roots);
                group--;
            } else {
                extractedCables++;
            }
        }
        return group - 1 > extractedCables ? -1 : group - 1;
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
