class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            result[i] = max;
        }

        int min = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (result[i] > nums[min]) {
                result[i] = Math.max(result[i], result[min]);
            }

            if (nums[i] < nums[min]) {
                min = i;
            }
        }

        return result;
    }
}
