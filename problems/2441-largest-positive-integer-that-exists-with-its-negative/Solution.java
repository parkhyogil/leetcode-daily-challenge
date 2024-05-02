class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        for (int l = 0, r = n - 1; l < r && nums[l] < 0 && nums[r] > 0;) {
            int a = Math.abs(nums[l]);
            int b = Math.abs(nums[r]);

            if (a > b) {
                l++;
            } else if (a < b) {
                r--;
            } else {
                return a;
            }
        }

        return -1;
    }
}
