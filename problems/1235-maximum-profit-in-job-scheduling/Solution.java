class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;

        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] cache = new int[n];
        Arrays.fill(cache, -1);

        return recur(n - 1, jobs, cache); 
    }

    private int recur(int idx, int[][] jobs, int[] cache) {
        if (idx < 0) {
            return 0;
        }

        if (cache[idx] != -1) {
            return cache[idx];
        }

        return cache[idx] = Math.max(jobs[idx][2] + recur(binarySearch(jobs, jobs[idx][0]), jobs, cache) , 
                                    recur(idx - 1, jobs, cache));
    }

    private int binarySearch(int[][] jobs, int target) {
        int lo = 0;
        int hi = jobs.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (jobs[mid][1] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return hi;
    }
}
