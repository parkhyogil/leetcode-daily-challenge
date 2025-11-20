class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int x = intervals[0][1] - 1;
        int y = intervals[0][1];

        int result = 2;

        for (int i = 1; i < n; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (y < s) {
                result += 2;
                x = e - 1;
                y = e;
            } else if (x < s) {
                x = y;
                y = e;
                result += 1;
            }
        }

        return result;
    }
}
