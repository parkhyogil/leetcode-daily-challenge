class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> res = new ArrayList<>();

        int idx = 0;
        while (idx < n && newInterval[1] >= intervals[idx][0]) {
            if (intervals[idx][1] < newInterval[0]) {
                res.add(intervals[idx++]);
            } else {
                merge(newInterval, intervals[idx++]);
            }
        }

        res.add(newInterval);
        
        while (idx < n) {
            res.add(intervals[idx++]);
        }

        return res.toArray(new int[res.size()][]);
    }

    private void merge(int[] newInterval, int[] interval) {
        newInterval[0] = Math.min(newInterval[0], interval[0]);
        newInterval[1] = Math.max(newInterval[1], interval[1]);
    }
}
