class Solution {
    Boolean[][] cache;

    public boolean checkValidString(String s) {
        int n = s.length();

        cache = new Boolean[n][n / 2 + 1];

        return recur(0, 0, s.toCharArray());
    }

    boolean recur(int i, int b, char[] arr) {
        if (b < 0 || b > arr.length - i) {
            return false;   
        }

        if (i == arr.length) {
            return b == 0;
        }

        if (cache[i][b] != null) {
            return cache[i][b];
        }

        boolean result;

        if (arr[i] == '(') {
            result = recur(i + 1, b + 1, arr);
        } else if (arr[i] == ')') {
            result = recur(i + 1, b - 1, arr);
        } else {
            result = recur(i + 1, b + 1, arr) || recur(i + 1, b - 1, arr) || recur(i + 1, b, arr);
        }

        return cache[i][b] = result;
    }
}
