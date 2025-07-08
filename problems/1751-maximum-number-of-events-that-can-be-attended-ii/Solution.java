class Solution {
    public int maxValue(int[][] events, int k) {
        if (k == 1) {
            int max = 0;

            for (int[] e : events) {
                max = Math.max(max, e[2]);
            }

            return max;
        }
        
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int[] prev = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            prev[i] = binarySearch(events[i][0], i - 1, events);
        }

        return recur(n - 1, k, events, prev, new int[n][k + 1]);
    }

    private int recur(int i, int k, int[][] events, int[] prev, int[][] cache) {
        if (i < 0 || k == 0) {
            return 0;
        }

        if (cache[i][k] != 0) {
            return cache[i][k];
        }

        int attend = events[i][2] + recur(prev[i], k - 1, events, prev, cache);
        int notAttend = recur(i - 1, k, events, prev, cache);

        return cache[i][k] = Math.max(attend, notAttend);
    }

    private int binarySearch(int target, int hi, int[][] events) {
        int lo = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (events[mid][1] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }
}
