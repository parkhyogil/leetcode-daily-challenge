class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int dx = coordinates[0][0] - coordinates[1][0];
        int dy = coordinates[0][1] - coordinates[1][1];

        for (int i = 2; i < coordinates.length; i++) {
            if (dy * (coordinates[0][0] - coordinates[i][0]) != dx * (coordinates[0][1] - coordinates[i][1])) {
                return false;
            }
        }
        return true;
    }
}
