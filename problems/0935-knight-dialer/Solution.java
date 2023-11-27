class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        int[][] graph = new int[][] {
            {4, 6}, 
            {6, 8}, {7, 9}, {4, 8},
            {3, 9, 0}, {}, {1, 7, 0},
            {2, 6}, {1, 3}, {2, 4}
        };

        int[] prev = new int[10];
        Arrays.fill(prev, 1);

        for (int i = 2; i <= n; i++) {
            int[] curr = new int[10];

            for (int num = 0; num <= 9; num++) {
                for (int nextNum : graph[num]) {
                    curr[num] = (curr[num] + prev[nextNum]) % MOD;
                }   
            }

            prev = curr;
        }

        int res = 0;
        for (int count : prev) {
            res = (res + count) % MOD;
        }
        return res;
    }
}
