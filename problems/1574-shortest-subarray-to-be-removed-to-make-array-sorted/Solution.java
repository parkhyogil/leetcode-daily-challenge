class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        boolean[] isSortedFromBegin = new boolean[n];
        boolean[] isSortedFromEnd = new boolean[n];

        isSortedFromBegin[0] = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                isSortedFromBegin[i] = true;
            } else {
                break;
            }
        }

        if (isSortedFromBegin[n - 1]) {
            return 0;
        }

        isSortedFromEnd[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                isSortedFromEnd[i] = true;
            } else {
                break;
            }
        }

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(n, mid, arr, isSortedFromBegin, isSortedFromEnd)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    boolean decide(int n, int length, int[] arr, boolean[] isSortedFromBegin, boolean[] isSortedFromEnd) {
        for (int i = 0; i + length <= n; i++) {
            if (i == 0) {
                if (isSortedFromEnd[i + length]) {
                    return true;
                }
            } else if (i + length == n) {
                if (isSortedFromBegin[i - 1]) {
                    return true;
                }
            } else {
                if (isSortedFromBegin[i - 1] && isSortedFromEnd[i + length] && arr[i - 1] <= arr[i + length]) {
                    return true;
                }
            }
        }
        return false;
    }
}
