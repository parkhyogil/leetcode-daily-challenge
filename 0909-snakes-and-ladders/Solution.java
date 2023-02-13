class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        boolean[] visit = new boolean[target + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = true;

        int numOfMoves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();

                if (cur == target) {
                    return numOfMoves;
                }

                for (int i = 1; i <= 6 && cur + i <= target; i++) {
                    int next = getNext(cur + i, board);

                    if (!visit[next]) {
                        q.offer(next);
                        visit[next] = true;
                    }
                }
            }
            numOfMoves++;
        }
        return -1;
    }

    private int getNext(int cur, int[][] board) {
        cur--;
        int n = board.length;
        int r = n - 1 - cur / n;
        int c = cur / n % 2 == 0 ? cur % n : n - 1 - cur % n;

        return board[r][c] == -1 ? cur + 1 : board[r][c];
    }
}
