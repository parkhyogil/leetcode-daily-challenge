class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int minIdx = -1;

        for (int i = 0; i < n; i++) {
            if (minIdx == -1 || nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }

        for (int i = 0; i < n && nums[minIdx] == nums[(minIdx - 1 + n) % n]; i++) {
            minIdx = (minIdx - 1 + n) % n;
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[(minIdx + i) % n] > nums[(minIdx + i + 1) % n]) {
                return false;
            }
        }

        return true;
    }
}
