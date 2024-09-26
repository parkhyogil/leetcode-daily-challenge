class MyCalendar {
    TreeMap<Integer, Integer> startToEndMap;

    public MyCalendar() {
        startToEndMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> prevEntry = startToEndMap.lowerEntry(end);
        if (prevEntry != null && prevEntry.getValue() > start) {
            return false;
        }

        startToEndMap.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
