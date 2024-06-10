class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;

        int[] count = new int[101];

        for (int height : heights) {
            count[height]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];

            if (i < count[height - 1] || i >= count[height]) {
                res++;
            }
        }

        return res;
    }
}
