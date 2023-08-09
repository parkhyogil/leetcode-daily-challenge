class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int n = nums.length;

        int lo = 0;
        int hi = nums[n - 1] - nums[0];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (countPair(nums, mid) >= p) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int countPair(int[] nums, int max) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= max) {
                count++;
                i++;
            }
        }
        return count;
    }
}
