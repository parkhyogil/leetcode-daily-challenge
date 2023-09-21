class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int len = m + n;

        int lo = 0;
        int hi = m;

        while (lo <= hi) {
            int leftCount = (lo + hi) / 2;
            int rightCount = (len + 1) / 2 - leftCount;

            int leftMin = leftCount == 0 ? Integer.MIN_VALUE : nums1[leftCount - 1];
            int leftMax = leftCount == m ? Integer.MAX_VALUE : nums1[leftCount];
            int rightMin = rightCount == 0 ? Integer.MIN_VALUE : nums2[rightCount - 1];
            int rightMax = rightCount == n ? Integer.MAX_VALUE : nums2[rightCount];

            if (leftMin <= rightMax && rightMin <= leftMax) {
                if (len % 2 == 1) {
                    return Math.max(leftMin, rightMin);
                } else {
                    return (Math.max(leftMin, rightMin) + Math.min(leftMax, rightMax)) / 2.0;
                }
            } else if (leftMin > rightMax) {
                hi = leftCount - 1;
            } else {
                lo = leftCount + 1;
            }
        }

        return -1.0;
    }
}
