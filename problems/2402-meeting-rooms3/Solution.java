class Solution {
    class Manager {
        class Book implements Comparable<Book> {
            private long endTime;
            private int roomNumber;

            public Book(long endTime, int roomNumber) {
                this.endTime = endTime;
                this.roomNumber = roomNumber;
            }

            @Override
            public int compareTo(Book o) {
                if (this.endTime == o.endTime) {
                    return Integer.compare(this.roomNumber, o.roomNumber);
                }
                return Long.compare(this.endTime, o.endTime);
            }
        }

        private int size;
        private int[] bookedCount;
        private PriorityQueue<Book> bookQueue;
        private PriorityQueue<Integer> roomQueue;

        public Manager(int size) {
            this.size = size;

            bookedCount = new int[size];
            bookQueue = new PriorityQueue<>(size);
            roomQueue = new PriorityQueue<>();
            
            for (int i = 0; i < size; i++) {
                roomQueue.offer(i);
            }
        }

        private long getStartTime(int[] time) {
            long startTime = time[0];

            while (!bookQueue.isEmpty() && bookQueue.peek().endTime <= startTime) {
                roomQueue.offer(bookQueue.poll().roomNumber);
            }

            if (bookQueue.size() == size) {
                startTime = bookQueue.peek().endTime;
                roomQueue.offer(bookQueue.poll().roomNumber);
            }

            return startTime;
        }

        public void bookRoom(int[] time) {
            long startTime = getStartTime(time);
            int roomNumber = roomQueue.poll();
            
            bookQueue.offer(new Book(startTime + time[1] - time[0], roomNumber));
            bookedCount[roomNumber]++;
        }

        public int getMostBookedRoom() {
            int res = 0;

            for (int i = 0; i < size; i++) {
                if (bookedCount[res] < bookedCount[i]) {
                    res = i;
                }
            }

            return res;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        Manager manager = new Manager(n);

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting  : meetings) {
            manager.bookRoom(meeting);
        }

        return manager.getMostBookedRoom();
    }
}
