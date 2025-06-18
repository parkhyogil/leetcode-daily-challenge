class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int[][] result = new int[n / 3][3];

        for (int i = 0, j = 0, l = 0; i < n / 3; i++) {
            while (l < n && nums[l] <= nums[j] + k) {
                l++;
            }

            if (l - j < 3) {
                return new int[0][];
            }

            result[i][0] = nums[j++];
            result[i][1] = nums[j++];
            result[i][2] = nums[j++];
        }

        return result;
    }
}
