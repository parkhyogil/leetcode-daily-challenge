class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> freeRoomQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> allocatedRoomQueue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            freeRoomQueue.offer(new int[] {i, 0});
        }

        int[] count = new int[n];

        for (int[] m : meetings) {
            int s = m[0], d = m[1] - m[0];

            while (!allocatedRoomQueue.isEmpty() && s >= allocatedRoomQueue.peek()[1]) {
                freeRoomQueue.offer(allocatedRoomQueue.poll());
            }

            if (freeRoomQueue.isEmpty()) {
                freeRoomQueue.offer(allocatedRoomQueue.poll());
            }

            int[] room = freeRoomQueue.poll();
            count[room[0]]++;
            room[1] = Math.max(s, room[1]) + d;

            allocatedRoomQueue.offer(room);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (count[i] > count[result]) {
                result = i;
            }
        }

        return result;
    }
}
