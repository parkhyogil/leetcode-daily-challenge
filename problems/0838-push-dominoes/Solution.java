class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();

        char[] chars = dominoes.toCharArray();

        int r = -1;
        int l = -1;

        for (int i = 0; i < n; i++) {
            char c = chars[i];

            if (c == 'R') {
                if (r != -1) {
                    Arrays.fill(chars, r + 1, i + 1, 'R');
                }
                r = i;
            } else if (c == 'L') {
                if (r == -1) {
                    Arrays.fill(chars, l + 1, i + 1, 'L');
                } else {
                    int length = (i - r + 1) / 2;

                    Arrays.fill(chars, r, r + length, 'R');
                    Arrays.fill(chars, i + 1 - length, i + 1, 'L');

                    r = -1;
                }
                l = i;
            }
        }

        if (r != -1) {
            Arrays.fill(chars, r, n, 'R');
        }

        return String.valueOf(chars);
    }
}
