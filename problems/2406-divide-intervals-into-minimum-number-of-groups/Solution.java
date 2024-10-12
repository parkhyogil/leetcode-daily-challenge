class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (!endTimes.isEmpty() && endTimes.peek() < start) {
                endTimes.poll();
            }
            endTimes.offer(end);
        }

        return endTimes.size();
    }
}
