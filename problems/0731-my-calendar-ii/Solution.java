class MyCalendarTwo {
    TreeMap<Integer, Integer> singleBookMap, doubleBookMap;

    public MyCalendarTwo() {
        singleBookMap = new TreeMap<>();
        doubleBookMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (isExistOverlappedBooking(doubleBookMap, start, end)) {
            return false;
        }

        if (!isExistOverlappedBooking(singleBookMap, start, end)) {
            singleBookMap.put(start, end);
            return true;
        }

        Map.Entry<Integer, Integer> singleBooking = singleBookMap.lowerEntry(end);

        int doubleBookingStart = Math.max(start, singleBooking.getKey());
        int doubleBookingEnd = Math.min(end, singleBooking.getValue());

        doubleBookMap.put(doubleBookingStart, doubleBookingEnd);

        if (doubleBookingEnd < end) {
            singleBookMap.put(doubleBookingEnd, end);
        }

        if (start < doubleBookingStart) {
            book(start, doubleBookingStart);
        }

        return true;
    }

    boolean isExistOverlappedBooking(TreeMap<Integer, Integer> bookMap, int start, int end) {
        Map.Entry<Integer, Integer> booking = bookMap.lowerEntry(end);

        return booking != null && booking.getValue() > start;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
