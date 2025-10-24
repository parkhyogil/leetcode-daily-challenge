class Solution {
    int max = Integer.MAX_VALUE;

    public int nextBeautifulNumber(int n) {
        if (n == 0) {
            return 1;
        }
        
        int len = ((int) Math.log10(n)) + 1;

        int result = recur(1, len, n, new boolean[10]);

        if (result < max) {
            return result;
        }

        return recur(1, len + 1, n, new boolean[10]);
    }

    int get(int x, int n, int len, int[] freq) {
        if (len == 0) {
            return x > n ? x : max;
        }

        for (int i = 1; i < 10; i++) {
            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;
            int result = get(x * 10 + i, n, len - 1, freq);
            freq[i]++;

            if (result < max) {
                return result;
            }
        }

        return max;
    }

    int recur(int i, int len, int n, boolean[] used) {
        if (len < 0) {
            return max;
        }

        if (len == 0) {
            int[] freq = new int[10];
            
            for (int j = 1; j < 10; j++) {
                if (used[j]) {
                    freq[j] = j;
                    len += j;
                }
            }

            return get(0, n, len, freq);
        }

        int result = max;

        for (int j = i; j < 10; j++) {
            used[j] = true;
            result = Math.min(result, recur(j + 1, len - j, n, used));
            used[j] = false;
        }

        return result;
    }
}
