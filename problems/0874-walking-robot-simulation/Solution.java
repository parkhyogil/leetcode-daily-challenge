class Solution {
    private final int[][] offset = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obstacleSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obstacleSet.add(getIndex(obstacle[0], obstacle[1]));
        }

        int result = 0;

        int direction = 0;
        int x = 0;
        int y = 0;

        for (int command : commands) {
            if (command == - 1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextX = offset[direction][0] + x;
                    int nextY = offset[direction][1] + y;

                    if (obstacleSet.contains(getIndex(nextX, nextY))) {
                        break;
                    }

                    x = nextX;
                    y = nextY;
                }

                result = Math.max(result, x * x + y * y);
            }
        }

        return result;
    }

    private int getIndex(int x, int y) {
        return x * 60001 + y;
    }
}
