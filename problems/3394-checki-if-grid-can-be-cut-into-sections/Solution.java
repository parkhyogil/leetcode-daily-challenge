class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[0], b[0]));

        int prevEnd = 0;
        int cuts = 0;

        for (int[] rect : rectangles) {
            if (rect[0] >= prevEnd) {
                cuts++;
                if (cuts == 3) {
                    return true;
                }
            }
            prevEnd = Math.max(prevEnd, rect[2]);
        }

        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[1], b[1]));

        prevEnd = 0;
        cuts = 0;

        for (int[] rect : rectangles) {
            if (rect[1] >= prevEnd) {
                cuts++;
                if (cuts == 3) {
                    return true;
                }
            }
            prevEnd = Math.max(prevEnd, rect[3]);
        }

        return false;
    }
}
