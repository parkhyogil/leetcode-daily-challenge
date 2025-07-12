class Solution {
    private int min, max, first, second;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        min = n;
        max = 0;
        first = firstPlayer - 1;
        second = secondPlayer - 1;

        int[] players = new int[n];
        for (int i = 0; i < n; i++) {
            players[i] = i;
        }

        recur(1, players);

        return new int[] {min, max};
    }

    private void recur(int round, int[] players) {
        if (twoPlayersMeet(players)) {
            min = Math.min(min, round);
            max = Math.max(max, round);
            return;
        }

        int n = players.length;

        int[] nextPlayers = new int[(n + 1) / 2];

        for (int i = 0; i < 1 << ((n - 2) / 2); i++) {
            setNextPlayers(n, i, players, nextPlayers);

            recur(round + 1, nextPlayers);
        }
    }

    private void setNextPlayers(int n, int mask, int[] curr, int[] next) {
        int j = 0;
        int k = next.length - 1;

        for (int i = 0; i < n / 2; i++) {
            int left = curr[i];
            int right = curr[n - 1 - i];

            if (left == first || left == second) {
                next[j++] = left;
            } else if (right == first || right == second) {
                next[k--] = right;
            } else if (mask % 2 == 0) {
                next[j++] = left;
                mask /= 2;
            } else {
                next[k--] = right;
                mask /= 2;
            }
        }

        if (n % 2 == 1) {
            next[j] = curr[n / 2];
        }
    }

    private boolean twoPlayersMeet(int[] players) {
        int n = players.length;

        for (int i = 0; i < n / 2; i++) {
            if (players[i] == first && players[n - 1 - i] == second) {
                return true;
            }
        }

        return false;
    }
}
