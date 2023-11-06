class SeatManager {
    private int currSeat;
    private PriorityQueue<Integer> unreservedSeat;

    public SeatManager(int n) {
        currSeat = 1;
        unreservedSeat = new PriorityQueue<>(n);
    }
    
    public int reserve() {
        if (unreservedSeat.isEmpty()) {
            return currSeat++;
        }
        return unreservedSeat.poll();
    }
    
    public void unreserve(int seatNumber) {
        if (seatNumber + 1 == currSeat) {
            currSeat--;
        } else {
            unreservedSeat.offer(seatNumber);
        }
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
