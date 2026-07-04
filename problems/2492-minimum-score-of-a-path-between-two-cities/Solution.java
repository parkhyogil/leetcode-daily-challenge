class Solution {
    int[] root, minD;

    public int minScore(int n, int[][] roads) {
        root = new int[n];
        minD = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            minD[i] = Integer.MAX_VALUE;
        }    

        for (int[] r : roads) {
            union(r[0] - 1, r[1] - 1, r[2]);
        }

        return minD[0];
    }

    int findRoot(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = findRoot(root[x]);
    }

    void union(int a, int b, int d) {
        a = findRoot(a);
        b = findRoot(b);

        int min = Math.min(d, Math.min(minD[a], minD[b]));

        if (a < b) {
            root[b] = a;
            minD[a] = min;
        } else {
            root[a] = b;
            minD[b] = min;
        }
    }
}
