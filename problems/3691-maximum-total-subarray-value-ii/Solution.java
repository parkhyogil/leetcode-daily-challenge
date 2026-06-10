class Solution {
    int[] val;
    int[][][] table;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        int h = 31 - Integer.numberOfLeadingZeros(n);

        val = nums;
        table = new int[h + 1][n][2];

        for (int i = 0; i < n; i++) {
            table[0][i] = new int[] {i, i};
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 0; j + (1 << i) <= n; j++) {
                int[] l = table[i - 1][j];
                int[] r = table[i - 1][j + (1 << (i - 1))];

                table[i][j][0] = nums[l[0]] < nums[r[0]] ? l[0] : r[0];
                table[i][j][1] = nums[l[1]] > nums[r[1]] ? l[1] : r[1];
            }
        }

        long result = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (val[b[3]] - val[b[2]]) - (val[a[3]] - val[a[2]]));

        for (int i = 0; i < n; i++) {
            int[] x = query(i, n - 1);
            queue.offer(new int[] {i, n - 1, x[0], x[1]});
        }

        while (k > 0 && !queue.isEmpty()) {
            int[] x = queue.poll();

            int l = x[0], r = x[1], min = x[2], max= x[3];

            int diff = val[max] - val[min];
            int count = r - Math.max(min, max) + 1;

            result += (long) diff * Math.min(count, k);
            k -= count;

            int nextR = Math.max(min, max) - 1;

            if (l <= nextR) {
                int[] y = query(l, nextR);
                queue.offer(new int[] {l, nextR, y[0], y[1]});
            }
        }

        return result;
    }

    int[] query(int l, int r) {
        int len = r - l + 1;

        int h = 31 - Integer.numberOfLeadingZeros(len);

        if ((len & (len - 1)) == 0) {
            return table[h][l];
        }

        int[] left = table[h][l];
        int[] right = table[h][r - (1 << h) + 1];

        int[] merged = new int[2];

        merged[0] = val[left[0]] < val[right[0]] ? left[0] : right[0];
        merged[1] = val[left[1]] > val[right[1]] ? left[1] : right[1];

        return merged;
    }
}
