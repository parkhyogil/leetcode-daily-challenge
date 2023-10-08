class Solution {
    private int[][] cache;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums1) {
            min1 = Math.min(min1, num);
            max1 = Math.max(max1, num);
        }

        for (int num : nums2) {
            min2 = Math.min(min2, num);
            max2 = Math.max(max2, num);
        }

        if (min1 > 0 && max2 < 0) {
            return min1 * max2;
        }

        if (max1 < 0 && min2 > 0) {
            return max1 * min2;
        }

        cache = new int[nums1.length][nums2.length];

        return recur(0, 0, nums1, nums2);
    }

    private int recur(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int res = nums1[i] * nums2[j] + recur(i + 1, j + 1, nums1, nums2);
        res = Math.max(res, Math.max(recur(i + 1, j, nums1, nums2), recur(i, j + 1, nums1, nums2)));
        return cache[i][j] = res;
    }
}
