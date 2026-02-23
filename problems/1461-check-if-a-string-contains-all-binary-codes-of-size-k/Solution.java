class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();

        if (n <= k) {
            return false;
        }

        int m = (1 << k) - 1;
        int count = m + 1;

        char[] arr = s.toCharArray();
        boolean[] contains = new boolean[m + 1];

        int mask = 0;

        for (int i = 0; i < k - 1; i++) {
            mask = (mask << 1) + arr[i] - '0';
        }

        for (int i = k - 1; i < n; i++) {
            mask = (m & (mask << 1)) + arr[i] - '0';

            if (!contains[mask]) {
                contains[mask] = true;
                count--;
            }
        }

        return count == 0;
    }
}
