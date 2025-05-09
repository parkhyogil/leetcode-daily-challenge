class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int countBalancedPermutations(String num) {
        int n = num.length();

        int sum = 0;
        int[] digitCount = new int[10];

        for (char c : num.toCharArray()) {
            int d = c - '0';

            digitCount[d]++;
            sum += d;
        }

        if (sum % 2 == 1) {
            return 0;
        }

        int even = n - n / 2;
        int odd = n - even;
        int targetSum = sum / 2;

        int[][] comb = new int[even + 1][even + 1];
        comb[0][0] = 1;

        for (int i = 1; i <= even; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        return (int) recur(0, targetSum, even, odd, digitCount, comb, new Long[10][targetSum + 1][even + 1]);
    }

    private long recur(int digit, int sum, int even, int odd, int[] digitCount, int[][] comb, Long[][][] memo) {
        if (sum < 0) {
            return 0;
        }

        if (digit > 9) {
            return sum == 0 ? 1 : 0;
        }

        if (memo[digit][sum][even] != null) {
            return memo[digit][sum][even];
        }

        long result = 0;

        for (int i = 0; i <= Math.min(even, digitCount[digit]); i++) {
            if (odd - (digitCount[digit] - i) >= 0) {
                long next = recur(digit + 1, sum - digit * i, even - i, odd - (digitCount[digit] - i), digitCount, comb, memo);
                
                result = (result + (next * comb[even][i] % MOD * comb[odd][digitCount[digit] - i])) % MOD;
            }
        }

        return memo[digit][sum][even] = result;
    }
}
