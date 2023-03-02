class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        int idx = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && chars[i] == chars[j]) {
                j++;
            }

            chars[idx++] = chars[i];
            int len = j - i;
            if (len > 1) {
                int d = 1;
                while (d * 10 <= len) {
                    d *= 10;
                }
                while (d > 0) {
                    chars[idx++] = (char) ('0' + len / d);
                    len %= d;
                    d /= 10;
                }
            }
        }
        return idx;
    }
}
