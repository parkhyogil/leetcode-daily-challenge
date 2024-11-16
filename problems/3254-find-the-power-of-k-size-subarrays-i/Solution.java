class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        int[] result = new int[n - k + 1];

        int r = 0;
        for (int l = 0; l <= n - k; l++) {
            if (r < l) { 
                r = l;
            }

            while (r - l + 1 < k && nums[r] + 1 == nums[r + 1]) {
                r++;
            }

            if (r - l + 1 == k) {
                result[l] = nums[r];
            } else {
                result[l] = -1;
            }
        }

        return result;
    }
}
