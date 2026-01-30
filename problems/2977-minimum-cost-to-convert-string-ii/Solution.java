class Solution {
    class Node {
        int idx;
        Node[] children;

        Node() {
            idx = -1;
            children = new Node[26];
        }
    }

    Map<String, Integer> map;
    Node root;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;

        map = new HashMap<>();
        root = new Node();

        for (int i = 0; i < m; i++) {
            String s = original[i];
            if (!map.containsKey(s)) {
                map.put(s, map.size());
            }
            insert(map.get(s), s, root);

            s = changed[i];
            if (!map.containsKey(s)) {
                map.put(s, map.size());
            }
            insert(map.get(s), s, root);
        }

        int[][] c = computeCost(m, original, changed, cost);

        long[] dp = new long[n + 1];
        long INF = Long.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = INF;
            int j = i;

            Node a = root;
            Node b = root;

            while (j < n && source.charAt(j) == target.charAt(j)) {
                if (a != null) {
                    a = a.children[source.charAt(j) - 'a'];
                }
                if (b != null) {
                    b = b.children[target.charAt(j) - 'a'];
                }
                dp[i] = Math.min(dp[i], dp[j + 1]);
                j++;
            }

            while (j < n && a != null && b != null) {
                a = a.children[source.charAt(j) - 'a'];
                b = b.children[target.charAt(j) - 'a'];

                if (dp[j + 1] < INF && a != null && b != null && a.idx != -1 && b.idx != -1 && c[a.idx][b.idx] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j + 1] + c[a.idx][b.idx]);
                }

                j++;
            }
        }

        return dp[0] < INF ? dp[0] : -1;
    }

    int[][] computeCost(int m, String[] original, String[] changed, int[] cost) {
        int l = map.size();
        int[][] c = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                c[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            c[map.get(original[i])][map.get(changed[i])] = Math.min(c[map.get(original[i])][map.get(changed[i])], cost[i]);
        }

        for (int k = 0; k < l; k++) {
            for (int i = 0; i < l; i++) {
                if (c[i][k] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < l; j++) {
                    if (c[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    c[i][j] = Math.min(c[i][j], c[i][k] + c[k][j]);
                }
            }
        }

        return c;
    }

    void insert(int idx, String s, Node node) {
        for (char c : s.toCharArray()) {
            int i = c - 'a';

            if (node.children[i] == null) {
                node.children[i] = new Node();
            }
            node = node.children[i];
        }
        node.idx = idx;
    }
}
