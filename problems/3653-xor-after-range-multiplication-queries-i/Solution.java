class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int mod = (int) 1e9 + 7;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            while (l <= r) {
                arr[l] = (arr[l] * v) % mod;
                l += k;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (int) arr[i];
        }
        return result;
    }
}
