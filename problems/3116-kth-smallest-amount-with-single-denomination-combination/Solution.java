class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        Arrays.sort(coins);

        if (coins[0] == 1) {
            return k;
        }

        long[] arr = new long[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            long x = 1;
            long y = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    y = gcd(x, coins[j]);
                    x = x * coins[j] / y;
                }
            }
            arr[i] = x;
        }


        long lo = 0;
        long hi = (long) coins[0] * k;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (count(mid, arr) < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    long count(long t, long[] arr) {
        long result = 0;

        for (int i = 1; i < arr.length; i++) {
            if (Integer.bitCount(i) % 2 == 1) {
                result += t / arr[i];
            } else {
                result -= t / arr[i];
            }
        }

        return result;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
