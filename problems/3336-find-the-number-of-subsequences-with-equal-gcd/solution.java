class Solution {
    int mod = (int) 1e9 + 7;
    int[][][] cache;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;

        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);    
        }

        cache = new int[n][max + 1][max + 1];
        for (int[][] a : cache) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return recur(0, 0, 0, nums);
    }

    int recur(int i, int a, int b, int[] nums) {
        if (i == nums.length) {
            return a > 0 && a == b ? 1 : 0;
        }

        if (cache[i][a][b] != -1) {
            return cache[i][a][b];
        }

        int result = recur(i + 1, a, b, nums);

        int x = nums[i];

        result = (result + recur(i + 1, gcd(a, x), b, nums)) % mod;
        result = (result + recur(i + 1, a, gcd(b, x), nums)) % mod;

        return cache[i][a][b] = result;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
