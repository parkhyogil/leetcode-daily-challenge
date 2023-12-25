class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] cache = new int[n];
        Arrays.fill(cache, -1);

        return recur(n - 1, s.toCharArray(), cache);
    }

    private int recur(int idx, char[] chars, int[] cache) {
        if (idx < 0) {
            return 1;
        }

        if (cache[idx] != -1) {
            return cache[idx];
        }

        int res = 0;

        if (chars[idx] != '0') {
            res = recur(idx - 1, chars, cache);
        }

        if (idx > 0 && (chars[idx - 1] == '1' || chars[idx - 1] == '2' && chars[idx] <= '6')) {
            res += recur(idx - 2, chars, cache);
        }

        return cache[idx] = res;
    }
}
