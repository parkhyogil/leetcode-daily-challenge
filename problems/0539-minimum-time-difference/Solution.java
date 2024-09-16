class Solution {
    class TimePoint implements Comparable<TimePoint> {
        private int hour, minute;

        public TimePoint(String s) {
            hour = Integer.parseInt(s.substring(0, 2));
            minute = Integer.parseInt(s.substring(3, 5));
        }

        public int getDiff(TimePoint o) {
            int minuteA = getMinutes();
            int minuteB = o.getMinutes();

            int earlierMinute = Math.min(minuteA, minuteB);
            int laterMinute = Math.max(minuteA, minuteB);

            return Math.min(laterMinute - earlierMinute, 1440 + earlierMinute - laterMinute);
        }

        public int getMinutes() {
            return hour * 60 + minute;
        }

        @Override
        public int compareTo(TimePoint o) {
            if (this.hour == o.hour) {
                return Integer.compare(this.minute, o.minute);
            }
            return Integer.compare(this.hour, o.hour);
        }
    }

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        List<TimePoint> timePointList = timePoints.stream().map(TimePoint::new).collect(Collectors.toList());
        timePointList.sort(null);

        int minDiff = 1440;

        for (int i = 0; i < n; i++) {
            minDiff = Math.min(minDiff, timePointList.get(i).getDiff(timePointList.get((i + 1) % n)));
        }

        return minDiff;
    }
}
