class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] freq = new int[40001];

        for (int x : nums) {
            freq[Math.abs(x)]++;
        }

        int l = 0;
        int r = 40000;

        long result = 0;

        while (l <= r) {
            while (l <= r && freq[r] == 0) {
                r--;
            }

            if (r < l) {
                return result;
            }

            result += r * r;
            freq[r]--;

            while (l <= r && freq[l] == 0) {
                l++;
            }

            if (r < l) {
                return result;
            }

            result -= l * l;
            freq[l]--;
        }

        return result;
    }
}
