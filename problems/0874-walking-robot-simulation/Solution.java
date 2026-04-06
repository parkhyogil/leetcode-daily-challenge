class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();

        for (int[] o : obstacles) {
            set.add(get(o[0], o[1]));
        }

        int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int x = 0;
        int y = 0;
        int result = 0;

        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d - 1 + 4) % 4;
            } else {
                for (int i = 1; i <= c; i++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    if (set.contains(get(nx, ny))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                }
            }

            result = Math.max(result, x * x + y * y);
        }

        return result;
    }

    long get(int x, int y) {
        return (x + 100000) * 1000000 + y + 100000;
    }
}
