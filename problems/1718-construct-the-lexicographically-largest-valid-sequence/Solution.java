class Solution {
    public int[] constructDistancedSequence(int n) {
        int length = (n - 1) * 2 + 1;

        int[] result = new int[length];

        backtracking(n, 0, length, new boolean[n + 1], result);

        return result;
    }

    boolean backtracking(int n, int idx, int len, boolean[] used, int[] result) {
        if (idx == len) {
            return true;
        }

        if (result[idx] != 0) {
            return backtracking(n, idx + 1, len, used, result);
        }

        for (int i = n; i > 1; i--) {
            if (used[i] || idx + i >= len || result[idx + i] != 0) {
                continue;
            }

            result[idx] = result[idx + i] = i;
            used[i] = true;

            if (backtracking(n, idx + 1, len, used, result)) {
                return true;
            }

            result[idx] = result[idx + i] = 0;
            used[i] = false;
        }

        if (!used[1]) {
            result[idx] = 1;
            used[1] = true;

            if (backtracking(n, idx + 1, len, used, result)) {
                return true;
            }

            result[idx] = 0;
            used[1] = false;
        }

        return false;
    }
}
