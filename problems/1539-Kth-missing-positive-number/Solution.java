class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (countMissingNum(arr, mid) >= k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo + k;
    }

    private int countMissingNum(int[] arr, int idx) {
        return arr[idx] - (idx + 1);
    }
}
