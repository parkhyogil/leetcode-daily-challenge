class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int result = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    count++;
                } else {
                    count--;
                }

                if (count > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
