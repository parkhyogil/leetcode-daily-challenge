class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;

        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = (dist[i] + speed[i] - 1) / speed[i];
        }

        Arrays.sort(min);

        for (int i = 0; i < n; i++) {
            if (min[i] - i == 0) {
                return i;
            }
        }
        return n;
    }
}
