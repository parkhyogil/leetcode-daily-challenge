class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        int result = 0;

        int continuousTime = 0;

        for (int l = 0, r = 0; r < n; r++) {
            continuousTime += endTime[r] - startTime[r];

            if (r - l + 1 > k) {
                continuousTime -= endTime[l] - startTime[l];
                l++;
            }

            result = Math.max(result, (r + 1 < n ? startTime[r + 1] : eventTime) - (l > 0 ? endTime[l - 1] : 0) - continuousTime);
        }

        return result;
    }
}
