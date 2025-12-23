class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new int[] {events[i][1], events[i][2]});
        }

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int result = 0;
        int max = 0;

        for (int i = 0, j = 0; i < n; i++) {
            while (list.get(j)[0] < events[i][0]) {
                max = Math.max(max, list.get(j++)[1]);
            }

            result = Math.max(result, max + events[i][2]);
        }

        return result;
    }
}
