class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int[][] prev = new int[n + 1][2];
        for (int[] a : prev) {
            Arrays.fill(a, -1);
        }

        int result = -1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            
            if (prev[x][1] != -1) {
                int d = i * 2 - prev[x][1] * 2;

                if (result == -1 || d < result) {
                    result = d;
                }
            }

            prev[x][1] = prev[x][0];
            prev[x][0] = i;
        }

        return result;
    }
}
