class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int n = nums.length;

        int lo = 0;
        int hi = nums[n - 1] - nums[0];

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (count(nums, mid) >= p) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private int count(int[] nums, int diff) {
        int result = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= diff) {
                result++;
                i++;
            }
        }

        return result;
    }
}
