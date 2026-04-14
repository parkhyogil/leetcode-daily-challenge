class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        robot.sort((a, b) -> a - b);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        Long[][] cache = new Long[m][n];

        return recur(0, 0, robot, factory, cache);
    }

    long recur(int i, int count, List<Integer> robot, int[][] factory, Long[][] cache) {
        if (count == robot.size()) {
            return 0;
        }

        if (i == factory.length) {
            return Long.MAX_VALUE / 2;
        }

        if (cache[i][count] != null) {
            return cache[i][count];
        }

        int pos = factory[i][0];
        int limit = factory[i][1];

        long result = recur(i + 1, count, robot, factory, cache);
        long sum = 0;

        for (int j = 0; j < limit && count + j < robot.size(); j++) {
            sum += Math.abs(pos - robot.get(count + j));
            result = Math.min(result, sum + recur(i + 1, count + 1 + j, robot, factory, cache));
        }

        return cache[i][count] = result;
    }
}
