class Solution {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();

        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);

        char[] permu = new char[n];
        Arrays.fill(permu, '*');

        return backtracking(0, n, chars, permu, new boolean[n]) - 1;
    }

    int backtracking(int idx, int n, char[] chars, char[] permu, boolean[] used) {
        if (idx == n) {
            return 1;
        }

        int result = 1;

        for (int i = 0; i < n; i++) {
            if (used[i] || (permu[idx] != '*' && permu[idx] == chars[i])) {
                continue;
            }

            used[i] = true;
            permu[idx] = chars[i];
            result += backtracking(idx + 1, n, chars, permu, used);
            used[i] = false;
        }

        permu[idx] = '*';

        return result;
    }
}
