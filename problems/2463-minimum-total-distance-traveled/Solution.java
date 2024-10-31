class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(Integer::compare);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();

        long[] prevMinDist = new long[n];
        Arrays.fill(prevMinDist, Long.MAX_VALUE);

        int limit = 0;
        for (int[] fact : factory) {
            int factoryPos = fact[0];

            for (int i = 0; i < fact[1]; i++) {
                long[] currMinDist = new long[n];
                Arrays.fill(currMinDist, Long.MAX_VALUE);

                limit++;

                currMinDist[0] = Math.abs(factoryPos - robot.get(0));

                for (int j = 1; j < Math.min(limit, n); j++) {
                    currMinDist[j] = Math.abs(factoryPos - robot.get(j)) + prevMinDist[j - 1];
                }

                for (int j = 0; j < n; j++) {
                    prevMinDist[j] = Math.min(prevMinDist[j], currMinDist[j]);
                }
            }
        }

        return prevMinDist[n - 1];
    }
}
