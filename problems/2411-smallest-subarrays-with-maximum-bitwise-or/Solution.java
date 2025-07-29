class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;

        int[] minIdx = new int[30];
        Arrays.fill(minIdx, n);

        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            for (int j = 0; j < 30 && num > 0; j++) {
                if (num % 2 == 1) {
                    minIdx[j] = i;
                }
                num /= 2;
            }    

            int max = i;

            for (int j = 0; j < 30; j++) {
                if (minIdx[j] < n && minIdx[j] > max) {
                    max = minIdx[j];
                }
            }

            result[i] = max - i + 1;
        }

        return result;
    }
}
