class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        List<Integer> friendsSortedByArrivalTime = new ArrayList<>();
        PriorityQueue<Integer> unoccupiedChairs = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 0; i < n; i++) {
            friendsSortedByArrivalTime.add(i);
        }
        friendsSortedByArrivalTime.sort((a, b) -> Integer.compare(times[a][0], times[b][0]));

        int lastChair = -1;
        
        for (int i = 0; i < n; i++) {
            int friend = friendsSortedByArrivalTime.get(i);
            int arrival = times[friend][0];
            int leaving = times[friend][1];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[1] <= arrival) {
                unoccupiedChairs.offer(occupiedChairs.poll()[0]);
            }

            int chair = unoccupiedChairs.isEmpty() ? ++lastChair : unoccupiedChairs.poll();

            if (friend == targetFriend) {
                return chair;
            }

            occupiedChairs.offer(new int[] {chair, leaving});
        }

        return -1;
    }
}
