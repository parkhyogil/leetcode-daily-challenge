class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        return recur(n - 1, m - 1, nums1, nums2, new Integer[n][m]);
    }

    int recur(int i, int j, int[] nums1, int[] nums2, Integer[][] cache) {
        if (i < 0 || j < 0) {
            return Integer.MIN_VALUE / 2;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int take = nums1[i] * nums2[j] + Math.max(recur(i - 1, j - 1, nums1, nums2, cache), 0);
        
        return cache[i][j] = Math.max(take, Math.max(recur(i - 1, j, nums1, nums2, cache), recur(i, j - 1, nums1, nums2, cache)));
    }
}
