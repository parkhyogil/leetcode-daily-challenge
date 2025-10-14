class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i + 2 * k - 1 < n; i++) {
            if (isIncreasing(i, k, nums) && isIncreasing(i + k, k, nums)) {
                return true;
            }
        }

        return false;
    }

    boolean isIncreasing(int i, int k, List<Integer> nums) {
        for (int j = i; j < i + k - 1; j++) {
            if (nums.get(j) >= nums.get(j + 1)) {
                return false;
            }
        }
        return true;
    }
}
