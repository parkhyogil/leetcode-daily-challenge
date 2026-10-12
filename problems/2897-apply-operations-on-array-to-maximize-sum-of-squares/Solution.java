class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] freq = new int[32];

        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                if ((x & 1) == 1) {
                    freq[i]++;
                }
                x /= 2;
            }
        }

        long result = 0;
        int mod = (int) 1e9 + 7;

        while (k > 0) {
            int min = k;

            
        }

        for (int i = 0; i < k; i++) {
            long x = 0;
            for (int j = 0; j < 32; j++) {
                if (freq[j] > 0) {
                    x |= 1 << j;
                    freq[j]--;
                }
            }

            result = (result + x * x % mod) % mod;
        }

        return (int) result;
    }
}
