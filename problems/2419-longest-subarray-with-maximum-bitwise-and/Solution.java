class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int maxElement = 0;
        int maxLength = 0;

        for (int i = 0; i < n;) {
            int end = i;

            while (end < n && nums[end] == nums[i]) {
                end++;
            }

            int currentLength = end - i;

            if (nums[i] > maxElement) {
                maxLength = currentLength;
                maxElement = nums[i];
            } else if (nums[i] == maxElement) {
                maxLength = Math.max(maxLength, (currentLength));
            }

            i = end;
        }

        return maxLength;
    }
}
