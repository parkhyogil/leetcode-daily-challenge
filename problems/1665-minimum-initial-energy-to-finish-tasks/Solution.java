class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            int d0 = a[1] - a[0];
            int d1 = b[1] - b[0];

            return d0 != d1 ? d1 - d0 : b[1] - a[1];
        });

        int result = 0;
        int e = 0;

        for (int[] t : tasks) {
            if (e < t[1]) {
                result += t[1] - e;
                e = t[1];
            }

            e -= t[0];
        }

        return result;
    }
}
