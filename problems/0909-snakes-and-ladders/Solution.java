class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int dest = n * n - 1;

        int[] jump = new int[dest + 1];
        for (int i = 0; i <= dest; i++) {
            int r = i / n;
            int c = i % n;
            if (r % 2 == 1) {
                c = n - 1 - c;
            }

            jump[i] = board[n - 1 - r][c] - 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[dest + 1];

        queue.offer(0);
        visited[0] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == dest) {
                    return result;
                }

                for (int i = curr + 1; i <= Math.min(curr + 6, dest); i++) {
                    int next = jump[i] < 0 ? i : jump[i];

                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            result++;
        }

        return -1;
    }
}
