class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int result = n;

        int p = 0;

        for (int i = 1; i < n; i++) {
            if (intervals[p][1] < intervals[i][1]) {
                p = i;
            } else {
                result--;
            }
        }

        return result;
    }
}
