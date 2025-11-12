class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int ones = 0;

        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }

        if (ones > 0) {
            return n - ones;
        }

        int result = 2 * n + 1;

        for (int i = 0; i < n - 1; i++) {
            int num = nums[i];
            int j = i + 1;

            while (j < n && num != 1) {
                num = getGCD(num, nums[j++]);
            }

            if (num == 1) {
                result = Math.min(result, n - 1 + (j - 1 - i));
            }
        }

        return result > 2 * n ? -1 : result;
    }

    int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}
