class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int m = landStartTime.length;
        int n = waterStartTime.length;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.min(result, Math.min(
                    landStartTime[i] + landDuration[i] > waterStartTime[j] ? landStartTime[i] + landDuration[i] + waterDuration[j] : waterStartTime[j] + waterDuration[j],
                    waterStartTime[j] + waterDuration[j] > landStartTime[i] ? waterStartTime[j] + waterDuration[j] + landDuration[i] : landStartTime[i] + landDuration[i]
                ));
            }
        }

        return result;
    }
}
