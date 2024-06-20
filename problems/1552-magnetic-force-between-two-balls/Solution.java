class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;

        Arrays.sort(position);

        int lo = 0;
        int hi = position[n - 1] - position[0];

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (decide(mid, m, position)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    private boolean decide(int distance, int m, int[] position) {
        int prevPos = position[0] - distance;

        for (int pos : position) {
            if (pos - prevPos >= distance) {
                m--;
                prevPos = pos;
            }
        }

        return m <= 0;
    }
}
