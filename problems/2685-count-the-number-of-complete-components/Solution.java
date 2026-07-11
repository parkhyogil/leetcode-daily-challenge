class Solution {
    int[] root, size, count;

    public int countCompleteComponents(int n, int[][] edges) {
        root = new int[n];
        size = new int[n];
        count = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            size[i] = 1;
        }    

        for (int[] e : edges) {
            union(e[0], e[1]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i == findRoot(i) && count[i] == size[i] * (size[i] - 1) / 2) {
                result++;
            }
        }

        return result;
    }

    void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a == b) {
            count[a]++;
            return;
        }

        if (a < b) {
            root[b] = a;
            size[a] += size[b];
            count[a] += count[b] + 1;
        } else {
            root[a] = b;
            size[b] += size[a];
            count[b] += count[a] + 1;
        }
    }

    int findRoot(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = findRoot(root[x]);
    }
}
