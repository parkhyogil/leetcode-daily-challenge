class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int m = walls.length;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, (a, b) -> robots[a] - robots[b]);
        Arrays.sort(walls);

        int leftBound = 0;
        int rightBound = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            int pos = robots[arr[i]];
            int dist = distance[arr[i]];

            int nextLeft = Math.max(
                left + count(Math.max(leftBound + 1, pos - dist), pos, walls),
                right + count(Math.max(rightBound + 1, pos - dist), pos, walls)
            );

            int nextRightBound = i + 1 < n ? Math.min(pos + dist, robots[arr[i + 1]] - 1) : pos + dist;
            int nextRight = count(pos, nextRightBound, walls) + Math.max(left, right);
            
            leftBound = pos;
            rightBound = nextRightBound;

            left = nextLeft;
            right = nextRight;
        }

        return Math.max(left, right);
    }

    int count(int left, int right, int[] arr) {
        return bs(right, arr) - bs(left - 1, arr);
    }

    int bs(int t, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int m = (lo + hi) / 2;

            if (arr[m] <= t) {
                lo = m + 1;
            } else {
                hi = m - 1;
            }
        }

        return hi;
    }
}
