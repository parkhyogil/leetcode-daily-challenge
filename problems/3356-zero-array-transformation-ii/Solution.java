class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int lo = 0;
        int hi = m;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(n, mid, nums, queries)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo > m ? -1 : lo;
    }

    boolean decide(int n, int k, int[] nums, int[][] queries) {
        int[] prefix = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            prefix[l] += val;
            prefix[r + 1] -= val;
        }

        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > prefix[i]) {
                return false;
            }
        }

        return true;
    }
}
