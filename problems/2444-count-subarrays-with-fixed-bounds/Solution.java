class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;

        int minCount = 0;
        int maxCount = 0;
        int leftCount = 0;

        long res = 0;

        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] < minK || nums[r] > maxK) {
                minCount = 0;
                maxCount = 0;
                leftCount = 0;
                l = r + 1;
                continue;
            }

            if (nums[r] == minK) {
                minCount++;
            } 
            if (nums[r] == maxK) {
                maxCount++;
            } 

            if (minCount >= 1 && maxCount >= 1) {
                while (true) {
                    if (nums[l] == minK) {
                        if (minCount == 1) {
                            break;
                        }
                        minCount--;
                    } else if (nums[l] == maxK) {
                        if (maxCount == 1) {
                            break;
                        }
                        maxCount--;
                    } 
                    leftCount++;
                    l++;
                }
                
                res += leftCount + 1;
            }
        }

        return res;
    }
}
