class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();

        if (n == k) {
            return n;
        }

        int vertical = 0;
        int horizontal = 0;

        int result = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'N') {
                vertical++;
            } else if (c == 'S') {
                vertical--;
            } else if (c == 'E') {
                horizontal++;
            } else {
                horizontal--;
            }

            result = Math.max(result, Math.min(i + 1, Math.abs(vertical) + Math.abs(horizontal) + k * 2));
        }

        return result;
    }
}
