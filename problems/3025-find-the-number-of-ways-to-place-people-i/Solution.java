class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        int result = 0;

        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1 == p2 || p1[0] > p2[0] || p1[1] < p2[1]) {
                    continue;
                }

                boolean isValid = true;

                for (int[] p : points) {
                    if (p == p1 || p == p2) {
                        continue;
                    }

                    if (p[0] >= p1[0] && p[0] <= p2[0] && p[1] <= p1[1] && p[1] >= p2[1]) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    result++;
                }
            }
        }

        return result;
    }
}
