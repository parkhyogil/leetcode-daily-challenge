class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] LIS = new int[n];
        int[] count = new int[n];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            LIS[i] = 1;
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (LIS[i] < LIS[j] + 1) {
                        count[i] = count[j];
                        LIS[i] = LIS[j] + 1;
                    } else if (LIS[i] == LIS[j] + 1){
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, LIS[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (LIS[i] == maxLen) {
                res += count[i]; 
            }
        }

        return res;
    }
}
