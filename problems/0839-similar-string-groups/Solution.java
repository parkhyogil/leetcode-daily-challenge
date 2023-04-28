class Solution {
    private int[] root;

    public int numSimilarGroups(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();

        root = new int[m];
        for (int i = 0; i < m; i++) {
            root[i] = i;
        }

        int res = m;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (isSimilar(strs[i], strs[j]) && findRoot(i) != findRoot(j)) {
                    res--;
                    union(i, j);
                }
            }
        }

        return res;
    }

    private void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    private int findRoot(int child) {
        if (root[child] == child) {
            return child;
        }
        return root[child] = findRoot(root[child]);
    }

    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length() && diff <= 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 2 || diff == 0;
    }
}
