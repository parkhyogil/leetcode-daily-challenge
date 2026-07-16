class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int max = 0;
        int[] pref = new int[n];

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            pref[i] = gcd(nums[i], max);
        }

        Arrays.sort(pref);
        long result = 0;

        for (int i = 0; i < n / 2; i++) {
            result += gcd(pref[i], pref[n - 1 - i]);
        }

        return result;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
