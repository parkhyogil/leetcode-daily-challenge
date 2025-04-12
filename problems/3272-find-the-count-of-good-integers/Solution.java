class Solution {
    private Set<String> set;
    private int[] factorial;

    public long countGoodIntegers(int n, int k) {
        set = new HashSet<>();
        factorial = new int[n + 1];

        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        return findKPalindromic(0, n - 1, new int[n], n, k);
    }

    private long findKPalindromic(int i, int j, int[] x, int n, int k) {
        if (i > j) {
            if (!isDivisibleByK(x, k)) {
                return 0;
            }
            return calculateGoodIntegers(n, x);
        }

        long result = 0;

        for (int digit = i == 0 ? 1 : 0; digit < 10; digit++) {
            x[i] = x[j] = digit;
            result += findKPalindromic(i + 1, j - 1, x, n, k);
        }

        return result;
    }

    private boolean isDivisibleByK(int[] x, int k) {
        long l = 0;
        for (int i : x) {
            l = l * 10 + i;
        }
        return l % k == 0;
    }

    private long calculateGoodIntegers(int n, int[] x) {
        String s = toSortedString(x);

        if (set.contains(s)) {
            return 0;
        }
        set.add(s);

        int[] digitCount = new int[10];

        long result = factorial[n];

        for (int i = 0; i < n; i++) {
            digitCount[x[i]]++;
        }

        for (int i = 0; i < 10; i++) {
            result /= factorial[digitCount[i]];
        }

        if (digitCount[0] > 0) {
            result = result - (result * digitCount[0] / n);
        }

        return result;
    }

    private String toSortedString(int[] x) {
        char[] chars = new char[x.length];

        for (int i = 0; i < x.length; i++) {
            chars[i] = (char) ('0' + x[i]);
        }

        Arrays.sort(chars);

        return String.valueOf(chars);
    }
}
