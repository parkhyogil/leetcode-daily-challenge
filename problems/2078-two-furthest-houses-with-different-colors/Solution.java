class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int a = 0;
        int b = n;
        int result = 0;

        for (int i = 1; i < n; i++) {
            if (colors[i] == colors[a]) {
                result = Math.max(result, i - b);
            } else {
                result = Math.max(result, i - a);
                b = Math.min(b, i);
            }
        }

        return result;
    }
}
