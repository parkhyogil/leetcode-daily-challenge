class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int res = 0;
        int end = intervals[0][0] - 1;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] < end) {
                res++;
            } else {
                end = intervals[i][1];
            }
        }
        return res;
    }
}
