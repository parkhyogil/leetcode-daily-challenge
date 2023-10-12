/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIdx = getPeakIdx(mountainArr);

        int leftIdx = binarySearch(0, peakIdx, mountainArr, target, false);

        if (leftIdx != -1) {
            return leftIdx;
        }

        int rightIdx = binarySearch(peakIdx + 1, mountainArr.length() - 1, mountainArr, -target, true);

        if (rightIdx != -1) {
            return rightIdx;
        }

        return -1;
    }

    private int binarySearch(int lo, int hi, MountainArray mountainArr, int target, boolean desc) {
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;
        int midVal = mountainArr.get(mid);

        if (desc) {
            midVal *= -1;
        }

        if (midVal < target) {
            return binarySearch(mid + 1, hi, mountainArr, target, desc);
        } 
        if (midVal > target) {
            return binarySearch(lo, mid - 1, mountainArr, target, desc);
        }
        return mid;
    }

    private int getPeakIdx(MountainArray mountainArr) {
        int lo = 1;
        int hi = mountainArr.length() - 2;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int midVal = mountainArr.get(mid);

            if (mountainArr.get(mid - 1) > midVal) {
                hi = mid - 1;
            } else if (midVal < mountainArr.get(mid + 1)) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
