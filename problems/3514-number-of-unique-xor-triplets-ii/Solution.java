class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        int m = 1 << (32 - Integer.numberOfLeadingZeros(max));
        boolean[] dp = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] dp1 = new boolean[m];

        for (int x : nums) {
            for (int i = 0; i < m; i++) {
                dp1[x ^ i] |= dp[i];
            }
        }

        int result = 0;

        for (boolean x : dp1) {
            if (x) {
                result++;
            }
        }

        return result;
    }
}
