class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();

        b = n - b;

        String result = s;

        char[][][] arr = new char[10][10][n];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < n; k++) {
                    arr[i][j][k] = (char) ('0' + (s.charAt(k) - '0' + a * (k % 2 == 0 ? j : i)) % 10);
                }

                String t = getString(n, 0, arr[i][j]);
                if (t.compareTo(result) < 0) {
                    result = t;
                }

                for (int k = b; k != 0; k = (k + b) % n) {
                    t = getString(n, k, arr[i][j]);
                    if (t.compareTo(result) < 0) {
                        result = t;
                    }
                }

                if (b % 2 == 0) {
                    break;
                }
            }
        }

        return result;
    }

    String getString(int n, int s, char[] chars) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(chars[(i + s) % n]);
        }

        return sb.toString();
    }
}
