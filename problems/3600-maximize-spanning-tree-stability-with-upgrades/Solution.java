class Solution {
    int[] root;

    public int maxStability(int n, int[][] edges, int k) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        List<int[]> upgradable = new ArrayList<>();
        int result = Integer.MAX_VALUE;
        int connected = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (findRoot(e[0]) == findRoot(e[1])) {
                    return -1;
                }

                connected++;
                union(e[0], e[1]);
                result = Math.min(result, e[2]);
            } else if (findRoot(e[0]) != findRoot(e[1])) {
                upgradable.add(e);
            }
        }

        if (connected == n - 1) {
            return result;
        }

        upgradable.sort((a, b) -> a[2] - b[2]);
        List<Integer> strength = new ArrayList<>();

        for (int i = upgradable.size() - 1; i >= 0 && connected < n - 1; i--) {
            int[] e = upgradable.get(i);
            int u = e[0];
            int v = e[1];
            int s = e[2];

            if (findRoot(u) == findRoot(v)) {
                continue;
            }

            union(u, v);
            strength.add(s);
            connected++;
        }

        if (connected < n - 1) {
            return -1;
        }

        int m = strength.size();
        if (k == 0) {
            return Math.min(result, strength.get(m - 1));
        }
        if (k >= m) {
            return Math.min(result, strength.get(m - 1) * 2);
        }

        return Math.min(result, Math.min(strength.get(m - 1) * 2, strength.get(m - 1 - k)));
    }

    int findRoot(int i) {
        if (i == root[i]) {
            return i;
        }
        return root[i] = findRoot(root[i]);
    }

    void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }
}
