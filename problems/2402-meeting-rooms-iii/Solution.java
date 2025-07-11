class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        PriorityQueue<int[]> bookedRooms = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            rooms.offer(i);
        }

        int[] numBooked = new int[n];

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!bookedRooms.isEmpty() && bookedRooms.peek()[1] <= start) {
                rooms.offer(bookedRooms.poll()[0]);
            }

            int room;
            int endTime;
            if (rooms.isEmpty()) {
                int[] lastBook = bookedRooms.poll();

                room = lastBook[0];
                endTime = lastBook[1] + end - start;
            } else {
                room = rooms.poll();
                endTime = end;
            }

            numBooked[room]++;
            bookedRooms.offer(new int[] {room, endTime});
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (numBooked[i] > numBooked[result]) {
                result = i;
            }
        }

        return result;
    }
}
