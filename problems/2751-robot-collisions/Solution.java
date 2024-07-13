class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        int[][] robots = new int[n][];

        for (int i = 0; i < n; i++) {
            robots[i] = new int[] {positions[i], i};
        }

        Arrays.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int idx = robots[i][1];
            int health = healths[idx];
            char dir = directions.charAt(idx);

            if (dir == 'R') {
                stack.push(idx);
                continue;
            }

            while (!stack.isEmpty() && health > 0) {
                int collisionRobotHealth = healths[stack.peek()];

                if (collisionRobotHealth > health) {
                    healths[stack.peek()]--;
                    health = 0;
                } else if (collisionRobotHealth < health) {
                    healths[stack.pop()] = 0;
                    health--;
                } else {
                    healths[stack.pop()] = 0;
                    health = 0;
                }
            }

            healths[idx] = health;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                res.add(healths[i]);
            }
        }

        return res;
    }
}
