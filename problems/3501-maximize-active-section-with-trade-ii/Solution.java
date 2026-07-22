import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[] tree;

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();

        int one = 0;
        int[] id = new int[n];
        int m = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '1') {
                one++;
            }

            if (m == -1 || c != s.charAt(i - 1)) {
                m++;
            }
            id[i] = m;
        }
        m++;

        int[] left = new int[m];
        int[] right = new int[m];
        int[] f = new int[m];

        Arrays.fill(left, -1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                f[id[i]]++;
            }

            if (left[id[i]] == -1) {
                left[id[i]] = i;
            }
            right[id[i]] = i;
        }

        for (int i = 0; i < m; i++) {
            if (s.charAt(left[i]) == '0') {
                if (i > 0) {
                    f[i - 1] += f[i];
                }
                if (i + 1 < m) {
                    f[i + 1] += f[i];
                }
                f[i] = 0;
            }
        }

        if (s.charAt(0) == '1') {
            f[0] = 0;
        }
        if (s.charAt(n - 1) == '1') {
            f[m - 1] = 0;
        }

        tree = new int[m * 4];
        build(1, 0, m - 1, f);

        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1];

            if (id[r] - id[l] <= 1) {
                result.add(one);
                continue;
            }

            char lc = s.charAt(l);
            char rc = s.charAt(r);

            int ql, qr;

            if (lc == '1') {
                ql = id[l] + 1;
            } else {
                ql = id[l] + 2;
            }

            if (rc == '1') {
                qr = id[r] - 1;
            } else {
                qr = id[r] - 2;
            }

            int max = query(1, 0, m - 1, ql, qr);

            if (lc == '0' && id[l] + 2 == id[r]) {
                max = Math.max(max, (right[id[l]] - l + 1) + (r - left[id[r]] + 1));
            } else {
                if (lc == '0') {
                    max = Math.max(max, f[id[l] + 1] - ((l - 1) - left[id[l]] + 1));
                }
                if (rc == '0') {
                    max = Math.max(max, f[id[r] - 1] - (right[id[r]] - (r + 1) + 1));
                }
            }

            result.add(max + one);
        }

        return result;
    }

    int query(int i, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) {
            return 0;
        }

        if (ql <= l && r <= qr) {
            return tree[i];
        }

        int m = (l + r) / 2;

        return Math.max(query(i * 2, l, m, ql, qr), query(i * 2 + 1, m + 1, r, ql, qr));
    }

    int build(int i, int l, int r, int[] val) {
        if (l == r) {
            return tree[i] = val[l];
        }

        int m = (l + r) / 2;

        return tree[i] = Math.max(build(i * 2, l, m, val), build(i * 2 + 1, m + 1, r, val));
    }
}
