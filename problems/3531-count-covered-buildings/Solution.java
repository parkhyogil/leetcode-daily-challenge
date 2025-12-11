class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] minX = new int[n + 1], maxX = new int[n + 1], minY = new int[n + 1], maxY = new int[n + 1];

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            if (minX[y] == 0 || minX[y] > x) {
                minX[y] = x;
            }           
            maxX[y] = Math.max(maxX[y], x);

            if (minY[x] == 0 || minY[x] > y) {
                minY[x] = y;
            }
            maxY[x] = Math.max(maxY[x], y);
        }

        int result = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            if ((minX[y] < x && x < maxX[y]) && (minY[x] < y && y < maxY[x])) {
                result++;
            }
        }

        return result;
    }
}
