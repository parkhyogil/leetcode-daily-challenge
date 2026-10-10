class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        int[] freq = new int[100001];

        for (int i = 0; i < n; i++) {
            freq[Math.abs(nums1[i] - nums2[i])]++;
        }

        long result = 0;
        int k = k1 + k2;

        for (int i = 100000; i > 0; i--) {
            int m = Math.min(k, freq[i]);

            k -= m;
            freq[i] -= m;
            freq[i - 1] += m;

            result += (long) freq[i] * i * i;
        }

        return result;
    }
}
