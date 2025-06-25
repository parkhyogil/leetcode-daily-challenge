class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long lo = (long) -1e10;
        long hi = (long) 1e10;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (count(mid, nums1, nums2) < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    private long count(long target, int[] nums1, int[] nums2) {
        long result = 0;

        for (int num : nums1) {
            result += binarySearch(target, num, nums2);
        }

        return result;
    }

    private long binarySearch(long target, long num, int[] arr) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            long x = num * arr[mid];

            if (x <= target) {
                if (num >= 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (num >= 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return num >= 0 ? left : n - right - 1;
    }
}
