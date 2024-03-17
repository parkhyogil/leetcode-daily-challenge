class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int i = 0;
        List<int[]> list = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        list.add(newInterval);        

        while (i < n) {
            list.add(intervals[i++]);
        }

        int[][] res = new int[list.size()][];
        i = 0;
        
        while (i < list.size()) {
            res[i] = list.get(i++);
        }
        
        return res;
    }
}
