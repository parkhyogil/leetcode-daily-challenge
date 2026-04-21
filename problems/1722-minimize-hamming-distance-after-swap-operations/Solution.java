class Solution {
    int[] root;
    List<Integer>[] lists;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        root = new int[n];
        lists = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            lists[i] = new ArrayList<>();
            lists[i].add(i);
        }

        for (int[] e : allowedSwaps) {
            union(e[0], e[1]);
        }

        int[] freq = new int[100001];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i == findRoot(i)) {
                for (int idx : lists[i]) {
                    freq[source[idx]]++;
                    freq[target[idx]]--;
                }

                for (int idx : lists[i]) {
                    if (freq[target[idx]] < 0) {
                        result++;
                    }
                    freq[target[idx]]++;
                }

                for (int idx : lists[i]) {
                    freq[source[idx]]--;
                }
            }
        }

        return result;
    }

    void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a == b) {
            return;
        }

        if (lists[a].size() < lists[b].size()) {
            root[a] = b;
            lists[b].addAll(lists[a]);
        } else {
            root[b] = a;
            lists[a].addAll(lists[b]);
        }
    }

    int findRoot(int a) {
        if (a == root[a]) {
            return a;
        }
        return root[a] = findRoot(root[a]);
    }
}
