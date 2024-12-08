class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        priorityQueue.addAll(Arrays.asList(events));
        priorityQueue.offer(new int[]{Integer.MAX_VALUE - 1, Integer.MAX_VALUE, 0});

        int result = 0;

        for (int[] event : events) {
            int end = event[1];
            int value = event[2];

            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= end) {
                priorityQueue.poll();
            }

            result = Math.max(result, value + priorityQueue.peek()[2]);
        }

        return result;
    }
}
