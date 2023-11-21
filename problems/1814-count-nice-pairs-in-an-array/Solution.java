class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> count = new HashMap<>();

        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i] - rev(nums[i]);

            int c = count.getOrDefault(num, 0);
            res = (res + c) % MOD;

            count.put(num, c + 1);
        }

        return res;
    }

    private int rev(int num) {
        int res = 0;

        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }

        return res;
    }
}
