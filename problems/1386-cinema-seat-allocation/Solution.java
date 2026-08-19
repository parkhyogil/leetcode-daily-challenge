class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int m = reservedSeats.length;

        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);
        int result = 0;

        for (int i = 0; i < m; i++) {
            int j = i;

            int b = 0;

            while (j < m && reservedSeats[i][0] == reservedSeats[j][0]) {
                b |= 1 << (reservedSeats[j++][1] - 1);
            }

            if ((b & 0b0111111110) == 0) {
                result += 2;
            } else if ((b & 0b0111100000) == 0 || (b & 0b0000011110) == 0 || (b & 0b0001111000) == 0) {
                result++;
            }

            i = j - 1;
            n--;
        }

        return result + n * 2;
    }
}
