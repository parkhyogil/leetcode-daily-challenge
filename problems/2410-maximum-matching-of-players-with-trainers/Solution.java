class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length;
        int m = trainers.length;

        Arrays.sort(players);
        Arrays.sort(trainers);

        int result = 0;

        for (int i = 0, j = 0; i < n && j < m; j++) {
            if (players[i] <= trainers[j]) {
                result++;
                i++;
            }
        }

        return result;
    }
}
