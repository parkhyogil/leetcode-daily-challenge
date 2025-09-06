class Solution {
    public long minOperations(int[][] queries) {
        long result = 0;

        for (int[] q : queries) {
            result += count(q);
        }

        return result;
    }

    long count(int[] query) {
        int l = query[0], r = query[1];

        long sum = 0;

        for (int i = 0, j = 1, k = 4; i < 15; i++, j *= 4, k *= 4) {
            sum += (long) Math.max(Math.min(k - 1, r) - Math.max(j, l) + 1, 0) * (i + 1);
        }

        return (sum + 1) / 2;
    }
}
