class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int[] freq = new int[51];

        for (int i = 0; i <= n - k; i++) {
            long x = 0;

            for (int j = 0; j < k; j++) {
                x |= 1L << nums[i + j];
            }

            while (x > 0) {
                long y = x & -x;

                freq[63 - Long.numberOfLeadingZeros(y)]++;

                x -= y;
            }
        }

        for (int i = 50; i >= 0; i--) {
            if (freq[i] == 1) {
                return i;
            }
        }

        return -1;
    }
}
