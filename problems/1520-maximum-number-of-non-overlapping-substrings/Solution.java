import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] l = new int[26];
        int[] r = new int[26];

        Arrays.fill(l, n + 1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            l[c] = Math.min(l[c], i);
            r[c] = i;
        }

        int[] mask = new int[26];

        for (int i = 0; i < 26; i++) {
            if (l[i] > n) {
                continue;
            }
            int left = l[i];
            int right = r[i];

            for (int j = l[i]; j <= r[i]; j++) {
                int c = s.charAt(j) - 'a';
                left = Math.min(l[c], left);
                right = Math.max(r[c], right);
                mask[i] |= 1 << c;
            }
            l[i] = left;
            r[i] = right;
        }

        List<int[]> subs = new ArrayList<>();

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (l[i] > n) {
                    continue;
                }

                for (int j = 0; j < 26; j++) {
                    if ((mask[i] & (1 << j)) > 0) {
                        mask[i] |= mask[j];
                    }
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (l[i] < n) {
                for (int j = 0; j < 26; j++) {
                    if ((mask[i] & (1 << j)) > 0) {
                        l[i] = Math.min(l[i], l[j]);
                        r[i] = Math.max(r[i], r[j]);
                    }
                }
                subs.add(new int[] {l[i], r[i], r[i] - l[i]});
            }
        }

        subs.sort((a, b) -> a[2] - b[2]);

        List<String> result = new ArrayList<>();
        boolean[] selected = new boolean[26];

        for (int i = 0; i < subs.size(); i++) {
            boolean overlapped = true;
            int[] x = subs.get(i);

            for (int j = 0; j < i; j++) {
                if (selected[j]) {
                    int[] y = subs.get(j);

                    overlapped &= x[0] > y[1] || x[1] < y[0];
                }
            }

            if (overlapped) {
                selected[i] = true;
                result.add(s.substring(x[0], x[1] + 1));
            }
        }

        return result;
    }
}
