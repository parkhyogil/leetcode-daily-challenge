class Solution {
    int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int slidingPuzzle(int[][] board) {
        String target = "123450";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        String start = sb.toString();

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();

        queue.offer(start);
        visit.add(start);

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return moves;
                }

                int zeroPos = curr.indexOf('0');

                for (int[] d : dir) {
                    int nr = zeroPos / 3 + d[0];
                    int nc = zeroPos % 3 + d[1];

                    if (isOutOfBoundary(nr, nc)) {
                        continue;
                    }

                    String next = swap(curr, zeroPos, nr * 3 + nc);

                    if (!visit.contains(next)) {
                        visit.add(next);
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);

        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        
        return sb.toString();
    }

    boolean isOutOfBoundary(int r, int c) {
        return r < 0 || r == 2 || c < 0 || c == 3;
    }
}
