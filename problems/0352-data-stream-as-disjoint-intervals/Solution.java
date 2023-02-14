class SummaryRanges {
    TreeSet<Integer> starts;
    int[] endOf;

    public SummaryRanges() {
        starts = new TreeSet<>();
        endOf = new int[10001];
        Arrays.fill(endOf, -1);
    }

    public void addNum(int value) {
        if (endOf[value] != -1) {
            return;
        }
        endOf[value] = value;

        if (value < 10000 && endOf[value + 1] != -1) {
            endOf[value] = getEnd(value + 1);
            starts.remove(value + 1);
        }

        if (value > 0 && endOf[value - 1] != -1) {
            endOf[value - 1] = getEnd(value);
        } else {
            starts.add(value);
        }
    }

    private int getEnd(int value) {
        if (endOf[value] == value) {
            return value;
        }
        return endOf[value] = getEnd(endOf[value]);
    }

    public int[][] getIntervals() {
        int[][] res = new int[starts.size()][];
        int idx = 0;
        for (int start : starts) {
            res[idx++] = new int[]{start, getEnd(start)};
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
