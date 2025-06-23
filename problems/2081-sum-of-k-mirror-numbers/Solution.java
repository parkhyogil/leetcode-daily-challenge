class Solution {
    public long kMirror(int k, int n) {
        long[] pow = new long[64];
        pow[0] = 1;
        for (int i = 1; i < 64; i++) {
            pow[i] = pow[i - 1] * k;
        }

        List<Long> mirrorNums = new ArrayList<>();
        int len = 1;

        while (mirrorNums.size() < n) {
            recur(0, len - 1, n, k, 0, pow, mirrorNums);

            len++;
        }

        long result = 0;

        for (long num : mirrorNums) {
            result += num;
        }

        return result;
    }

    private void recur(int l, int r, int n, int k, long kBase, long[] pow, List<Long> mirrorNums) {
        if (mirrorNums.size() == n) {
            return;
        }

        if (l > r) {
            if (isMirrorNum(kBase)) {
                mirrorNums.add(kBase);
            }
            return;
        }

        for (int i = (l == 0 ? 1 : 0); i < k; i++) {
            long next = kBase + i * pow[l];
            if (r > l) {
                next += i * pow[r];
            }

            recur(l + 1, r - 1, n, k, next, pow, mirrorNums);
        }
    }

    private boolean isMirrorNum(long num) {
        long x = num;
        long flipped = 0;

        while (x > 0){
            flipped = flipped * 10 + x % 10;
            x /= 10;
        }

        return num == flipped;
    }
}
