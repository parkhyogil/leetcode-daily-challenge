class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            getTime(landStartTime, landDuration, waterStartTime, waterDuration),
            getTime(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    int getTime(int[] s0, int[] d0, int[] s1, int[] d1) {
        int m = s0.length;
        int n = s1.length;

        int x = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            x = Math.min(x, s0[i] + d0[i]);
        }

        int y = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            y = Math.min(y, Math.max(x, s1[i]) + d1[i]);
        }

        return y;
    }
}
