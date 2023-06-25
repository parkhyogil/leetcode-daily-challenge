class Solution {
    private final int mod = (int) 1e9 + 7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;

        int[][] memo = new int[n][fuel + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return recur(start, finish, fuel, locations, memo);
    }

    private int recur(int city, int finish, int fuel, int[] locations, int[][] memo) {
        if (fuel < 0) {
            return 0;
        }

        if (memo[city][fuel] != -1) {
            return memo[city][fuel];
        }

        int res = city == finish ? 1 : 0;
        for (int i = 0; i < locations.length; i++) {
            if (i == city) {
                continue;
            }
            res += recur(i, finish, fuel - Math.abs(locations[city] - locations[i]), locations, memo);
            res %= mod;
        }
        return memo[city][fuel] = res;
    }
}
