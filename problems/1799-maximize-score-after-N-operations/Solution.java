class Solution {
    private int[] memo;
    private int[][] gcd;

    public int maxScore(int[] nums) {
        int len = nums.length;
        int n = len / 2;

        memo = new int[1 << len];
        Arrays.fill(memo, -1);

        gcd = new int[len][len];
        for (int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                gcd[x][y] = getGCD(nums[x], nums[y]);
            }
        }

        return recur((1 << len) - 1, n, nums);
    }

    private int recur(int bit, int n, int[] nums) {
        if (n == 0) {
            return 0;
        }
        if (memo[bit] != -1) {
            return memo[bit];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((bit & (1 << i)) == 0) {
                continue;
            }
            bit -= 1 << i;
            for (int j = 0; j < i; j++) {
                if ((bit & (1 << j)) == 0) {
                    continue;
                }
                bit -= 1 << j;
                res = Math.max(res, gcd[i][j] * n + recur(bit, n - 1, nums));
                bit += 1 << j;
            }
            bit += 1 << i;
        }
        return memo[bit] = res;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
