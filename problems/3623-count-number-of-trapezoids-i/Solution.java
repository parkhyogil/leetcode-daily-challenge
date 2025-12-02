class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;

        Arrays.sort(points, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int mod = (int) 1e9 + 7;
        long result = 0, prev = 0;

        for (int i = 0; i < n; i++) {
            int j = i + 1;

            while (j < n && points[i][1] == points[j][1]) {
                j++;
            }

            long k = j - i;
            long curr = k * (k - 1) / 2;

            result += prev * curr;
            prev += curr;

            i = j - 1;
        }

        return (int) (result % mod);
    }
}
