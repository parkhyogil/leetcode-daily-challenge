class Solution {
    public int findKthNumber(int n, int k) {
        for (int i = 1; i <= 9; i++) {
            int subTreeCount = countSubTree(i, n);

            if (subTreeCount >= k) {
                return findInSubTree(i, n, k);
            } else {
                k -= subTreeCount;
            }
        }

        return -1;
    }

    int findInSubTree(int prefix, int n, int k) {
        if (k == 1) {
            return prefix;
        }

        k--;

        for (int i = 0; i <= 9; i++) {
            int nextPrefix = prefix * 10 + i;
            int subTreeCount = countSubTree(nextPrefix, n);

            if (subTreeCount >= k) {
                return findInSubTree(nextPrefix, n, k);
            } else {
                k -= subTreeCount;
            }
        }

        return -1;
    }

    int countSubTree(int i, int n) {
        int result = 1;

        long begin = i * 10L;
        long end = begin + 9;

        while (begin <= n) {
            result += Math.min(n, end) - begin + 1;

            begin *= 10;
            end = end * 10 + 9;
        }

        return result;
    }
}
