class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        int res = recur(0, Integer.MIN_VALUE, arr1, arr2, new HashMap<>());
        return res <= 2000 ? res : -1;
    }

    private int recur(int idx, int prev, int[] arr1, int[] arr2, Map<Pair<Integer, Integer>, Integer> memo) {
        if (idx == arr1.length) {
            return 0;
        }

        Pair<Integer, Integer> key = new Pair<>(idx, prev);
        if (!memo.containsKey(key)) {
            int res = 2001;
            if (arr1[idx] > prev) {
                res = recur(idx + 1, arr1[idx], arr1, arr2, memo);
            }

            int pos = binarySearch(arr2, prev);
            if (pos < arr2.length) {
                res = Math.min(res, 1 + recur(idx + 1, arr2[pos], arr1, arr2, memo));
            }
            
            memo.put(key, res);
        }
        return memo.get(key);
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
