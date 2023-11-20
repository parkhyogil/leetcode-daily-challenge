class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;

        int M = 0;
        int P = 0;
        int G = 0;

        int res = 0;

        for (int i = 0; i < n; i++) {
            String g = garbage[i];

            for (char c : g.toCharArray()) {
                if (c == 'M') {
                    M = i;
                } else if (c == 'P') {
                    P = i;
                } else {
                    G = i;
                }
            }

            res += g.length();
        }

        for (int i = 1; i < n - 1; i++) {
            travel[i] += travel[i - 1];
        }

        if (M > 0) {
            res += travel[M - 1];
        }
        if (P > 0) {
            res += travel[P - 1];
        }
        if (G > 0) {
            res += travel[G - 1];
        }

        return res;
    }
}
