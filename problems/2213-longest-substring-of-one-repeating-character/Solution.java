class Solution {
    int[][] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int k = queryIndices.length;

        tree = new int[n * 4][];

        build(1, 0, n - 1, arr);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);

            result[i] = update(1, 0, n - 1, idx, c, arr)[5];
        }

        return result;
    }

    int[] update(int i, int l, int r, int idx, char c, char[] arr) {
        if (idx < l || idx > r) {
            return tree[i];
        }

        if (l == r) {
            arr[idx] = c;
            return tree[i] = new int[] {c - 'a', 1, c - 'a', 1, 1, 1};
        }

        int m = (l + r) / 2;

        int[] left = update(i * 2, l, m, idx, c, arr);
        int[] right = update(i * 2 + 1, m + 1, r, idx, c, arr);

        return tree[i] = merge(left, right);
    }

    //leftchar, leftlen, rightchar, rightlen, same, max;??
    int[] build(int i, int l, int r, char[] arr) {
        if (l == r) {
            return tree[i] = new int[] {arr[l] - 'a', 1, arr[r] - 'a', 1, 1, 1};
        }

        int m = (l + r) / 2;

        int[] left = build(i * 2, l, m, arr);
        int[] right = build(i * 2 + 1, m + 1, r, arr);

        return tree[i] = merge(left, right);
    }

    int[] merge(int[] l, int[] r) {
        int left = l[0];
        int right = r[2];
        int leftLen = l[4] == 1 && l[0] == r[0] ? l[1] + r[1] : l[1];
        int rightLen = r[4] == 1 && r[0] == l[2] ? l[3] + r[3] : r[3];
        int one = l[4] == 1 && r[4] == 1 && l[2] == r[0] ? 1 : 0;

        int max = Math.max(Math.max(l[5], r[5]), Math.max(leftLen, rightLen));
        if (l[2] == r[0]) {
            max = Math.max(max, l[3] + r[1]);
        }
        
        return new int[] {left, leftLen, right, rightLen, one, max};
    }
}
