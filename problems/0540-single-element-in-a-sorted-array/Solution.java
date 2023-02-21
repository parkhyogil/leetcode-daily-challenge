class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left + 2 <= right) {
            int mid = (left + right) / 2;

            if (nums[mid - 1] == nums[mid]) {
                mid++;
            }

            int leftLen = mid - left;
            if (leftLen % 2 == 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
