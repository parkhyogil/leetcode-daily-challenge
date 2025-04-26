class Solution {
    private long slidingWindow(int i, int j, int minK, int maxK, int[] nums) {
        if (i == j) {
            return 0;
        }
        
        long result = 0;
        int minCount = 0;
        int maxCount = 0;

        for (int l = i, r = i; r < j; r++) {
            if (nums[r] == minK) {
                minCount++;
            } 
            if (nums[r] == maxK) {
                maxCount++;
            }

            while (minCount > 0 && maxCount > 0) {
                result += j - r;

                if (nums[l] == minK) {
                    minCount--;
                }
                if (nums[l] == maxK) {
                    maxCount--;
                }
                l++;
            }
        }

        return result;
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        if (minK > maxK) {
            return 0;
        }

        int n = nums.length;

        long result = 0;
        int prev = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                result += slidingWindow(prev + 1, i, minK, maxK, nums);
                prev = i;
            }
        }

        return result + slidingWindow(prev + 1, n, minK, maxK, nums);
    }
}
