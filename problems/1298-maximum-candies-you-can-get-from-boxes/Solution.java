class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] lockedBoxes = new boolean[n];

        for (int box : initialBoxes) {
            if (status[box] == 1) {
                queue.offer(box);
            } else {
                lockedBoxes[box] = true;
            }
        }

        int result = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();

            result += candies[box];

            for (int key : keys[box]) {
                status[key] = 1;

                if (lockedBoxes[key]) {
                    queue.offer(key);
                    lockedBoxes[key] = false;
                }
            }

            for (int containedBox : containedBoxes[box]) {
                if (status[containedBox] == 1) {
                    queue.offer(containedBox);
                } else {
                    lockedBoxes[containedBox] = true;
                }
            }
        }

        return result;
    }
}
