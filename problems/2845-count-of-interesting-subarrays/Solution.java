class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();

        int[] count = new int[n + 1];
        count[0] = 1;

        int prev = 0;

        long result = 0;

        for (int i = 0; i < n; i++) {
            prev = (prev + (nums.get(i) % modulo == k ? 1 : 0)) % modulo;

            int j = (modulo + prev - k) % modulo;

            if (j < n) {
                result += count[j];
            }

            count[prev]++;
        }

        return result;
    }
}
