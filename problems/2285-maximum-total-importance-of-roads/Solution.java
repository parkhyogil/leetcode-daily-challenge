class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = countDegree(n, roads);

        Arrays.sort(degree);

        long res = 0;
        long val = 1;

        for (int d : degree) {
            res += val * d;
            val++;
        }

        return res;
    }

    private int[] countDegree(int n, int[][] edges) {
        int[] res = new int[n];

        for (int[] edge : edges) {
            res[edge[0]]++;
            res[edge[1]]++;
        }

        return res;
    }
}
