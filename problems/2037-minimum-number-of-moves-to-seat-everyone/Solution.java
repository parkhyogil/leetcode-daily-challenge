class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;

        int[] count = new int[101];

        for (int i = 0; i < n; i++) {
            count[seats[i]]++;
            count[students[i]]--;
        }

        int unmatched = 0;
        int res = 0;

        for (int c : count) {
            res += Math.abs(unmatched);
            unmatched += c;
        }

        return res;
    }
}
