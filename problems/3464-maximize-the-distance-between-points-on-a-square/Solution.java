class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int lo = 1;
        int hi = side * 2;

        List<int[]> list = arrangePoints(side, points);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (decide(mid, k, list)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    boolean decide(int dist, int k, List<int[]> points) {
        int n = points.size();

        int[] next = new int[n];
        Arrays.fill(next, -1);

        for (int i = 0, j = 0; i < n; i++) {
            while (j < n && getDist(points.get(i), points.get(j)) < dist) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 0; i <= n - k; i++) {
            int p = i;
            for (int j = 0; j < k - 1 && p < n; j++) {
                p = next[p];
            }

            if (p < n && getDist(points.get(i), points.get(p)) >= dist) {
                return true;
            }
        }

        return false;
    }

    int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    List<int[]> arrangePoints(int side, int[][] points) {
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        List<int[]> top = new ArrayList<>();
        List<int[]> bottom = new ArrayList<>();

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            if (x == 0) {
                left.add(p);
            } else if (x == side) {
                right.add(p);
            } else if (y == 0) {
                bottom.add(p);
            } else {
                top.add(p);
            }
        }

        List<int[]> result = new ArrayList<>();

        left.sort((a, b) -> a[1] - b[1]);
        right.sort((a, b) -> b[1] - a[1]);
        top.sort((a, b) -> a[0] - b[0]);
        bottom.sort((a, b) -> b[0] - a[0]);

        result.addAll(left);
        result.addAll(top);
        result.addAll(right);
        result.addAll(bottom);

        return result;
    }
}
