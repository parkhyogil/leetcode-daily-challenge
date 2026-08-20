class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];
        int[] tmp = new int[n];

        result[0] = nums[0];
        tmp[0] = nums[1];
        int i = 0;
        int j = 0;

        for (int k = 2; k < n; k++) {
            if (result[i] > tmp[j]) {
                result[++i] = nums[k];
            } else {
                tmp[++j] = nums[k];
            }
        }

        for (int k = 0; k <= j; k++) {
            result[++i] = tmp[k];
        }

        return result;
    }
}
