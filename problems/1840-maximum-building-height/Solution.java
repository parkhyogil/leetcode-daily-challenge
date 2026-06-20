class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);

        int[] max = new int[m];
        int prev = 1;
        int prevH = 0;

        for (int i = 0; i < m; i++) {
            int curr = restrictions[i][0];
            int h = restrictions[i][1];

            int len = curr - prev;

            max[i] = Math.min(h, prevH + len);
            prev = curr;
            prevH = max[i];
        }

        prev = n;
        prevH = n;

        for (int i = m - 1; i >= 0; i--) {
            int curr = restrictions[i][0];
            int h = restrictions[i][1];

            int len = prev - curr;

            max[i] = Math.min(max[i], Math.min(h, prevH + len));
            prev = curr;
            prevH = max[i];
        }

        int result = 0;

        prev = 1;
        prevH = 0;

        for (int i = 0; i < m; i++) {
            int curr = restrictions[i][0];
            int h = max[i];

            int len = curr - prev - 1;

            result = Math.max(result, Math.max(prevH, h) + (len - (Math.max(prevH, h) - Math.min(prevH, h)) + 1) / 2);

            prev = curr;
            prevH = h;
        }

        return Math.max(result, n - prev + prevH);
    }
}
