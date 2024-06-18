class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        int[][] jobs = new int[n][];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {difficulty[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < n; i++) {
            jobs[i][1] = Math.max(jobs[i][1], jobs[i - 1][1]);
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            res += binarySearch(0, n - 1, jobs, worker[i]);
        }

        return res;
    }

    private int binarySearch(int lo, int hi, int[][] jobs, int target) {
        if (lo > hi) {
            return hi < 0 ? 0 : jobs[hi][1];
        }

        int mid = (lo + hi) / 2;

        if (jobs[mid][0] <= target) {
            return binarySearch(mid + 1, hi, jobs, target);
        }
        return binarySearch(lo, mid - 1, jobs, target);
    }
}
