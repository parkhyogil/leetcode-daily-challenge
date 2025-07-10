class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        int[] rightMaxGap = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxGap[i] = Math.max(rightMaxGap[i + 1], (i + 2 < n ? startTime[i + 2] : eventTime) - endTime[i + 1]);
        }

        int result = 0;

        int leftMaxGap = 0;

        for (int i = 0; i < n; i++) {
            int gap = (i + 1 < n ? startTime[i + 1] : eventTime) - (i > 0 ? endTime[i - 1] : 0);
            int duration = endTime[i] - startTime[i];

            if (leftMaxGap >= duration || rightMaxGap[i] >= duration) {
                result = Math.max(result, gap);
            } else {
                result = Math.max(result, gap - duration);
            }

            leftMaxGap = Math.max(leftMaxGap, startTime[i] - (i > 0 ? endTime[i - 1] : 0));
        }

        return result;
    }
}
