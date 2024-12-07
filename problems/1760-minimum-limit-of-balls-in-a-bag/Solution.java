class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1;
        int hi = (int) 1e9;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (countOperation(mid, nums) <= maxOperations) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    int countOperation(int limit, int[] nums) {
        int operations = 0;

        for (int num : nums) {
            operations += (num + limit - 1) / limit - 1;
        }

        return operations;
    }
}
