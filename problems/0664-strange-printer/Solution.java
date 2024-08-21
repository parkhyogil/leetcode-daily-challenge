class Solution {
    public int strangePrinter(String s) {
        int n = s.length();

        int[][] cache = new int[n][n];

        return dfs(0, n - 1, s.toCharArray(), cache);
    }

    private int dfs(int left, int right, char[] chars, int[][] cache) {
        if (left == right) {
            return 1;
        }

        if (cache[left][right] != 0) {
            return cache[left][right];
        }

        int result = right - left + 1;

        for (int i = left; i < right; i++) {
            int leftPart = dfs(left, i, chars, cache);
            int rightPart = dfs(i + 1, right, chars, cache);

            if ((leftPart == 1 && (chars[left] == chars[i + 1] || chars[left] == chars[right])) 
                || (rightPart == 1 && (chars[right] == chars[left] || chars[right] == chars[i]))) {
                result = Math.min(result, Math.max(leftPart, rightPart));
            } else {
                result = Math.min(result, leftPart + rightPart);
            }
        }

        return cache[left][right] = result;
    }
}
