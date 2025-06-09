class Solution {
    public int findKthNumber(int n, int k) {
        for (int i = 1; i < 10; i++) {
            int count = countSubtree(i, n);

            if (count >= k) {
                return find(i, n, k);
            } else {
                k -= count;
            }
        }

        return -1;
    }

    private int find(int prefix, int n, int k) {
        if (k == 1) {
            return prefix;
        }
        k--;

        for (int i = 0; i < 10; i++) {
            int count = countSubtree(prefix * 10 + i, n);

            if (count >= k) {
                return find(prefix * 10 + i, n, k);
            } else {
                k -= count;
            }
        }

        return -1;
    }

    private int countSubtree(int num, int n) {
        long min = num;
        long max = num;

        int result = 0;

        while (min <= n) {
            result += Math.min(n, max) - min + 1;

            min *= 10;
            max = max * 10 + 9;
        }

        return result;
    }
}
