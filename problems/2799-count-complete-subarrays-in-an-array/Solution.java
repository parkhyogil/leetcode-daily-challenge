class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        int[] arrCount = new int[2001];
        int arrDistinctCount = 0;

        for (int num : nums) {
            if (arrCount[num]++ == 0) {
                arrDistinctCount++;
            }
        }

        int[] subarrCount = new int[2001];
        int subarrDistinctCount = 0;

        int result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            if (subarrCount[nums[r]]++ == 0) {
                subarrDistinctCount++;
            }

            while (subarrDistinctCount == arrDistinctCount) {
                result += n - r;

                if (--subarrCount[nums[l++]] == 0) {
                    subarrDistinctCount--;
                }
            }
        }

        return result;
    }
}
