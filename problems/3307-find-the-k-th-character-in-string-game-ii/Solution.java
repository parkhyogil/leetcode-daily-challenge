class Solution {
    public char kthCharacter(long k, int[] operations) {
        k--;

        int increaseCount = 0;

        for (int i = 0; k > 0; i++) {
            if (k % 2 == 1) {
                increaseCount += operations[i];
            }
            k /= 2;
        }

        return (char) ('a' + increaseCount % 26);
    }
}
