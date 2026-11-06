class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int k = logs.length;

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        List<Integer> qidx = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            qidx.add(i);
        }

        qidx.sort((a, b) -> queries[a] - queries[b]);

        int[] f = new int[n + 1];
        int[] result = new int[m];

        int d = 0;

        for (int i = 0, l = 0, r = 0; i < m; i++) {
            int q = queries[qidx.get(i)];

            while (r < k && logs[r][1] <= q) {
                if (f[logs[r][0]] == 0) {
                    d++;
                }
                f[logs[r][0]]++;
                r++;
            }

            while (l < k && logs[l][1] < q - x) {
                f[logs[l][0]]--;
                if (f[logs[l][0]] == 0) {
                    d--;
                }
                l++;
            }

            result[qidx.get(i)] = n - d;
        }

        return result;
    }
}
