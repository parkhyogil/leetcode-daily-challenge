class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] count = new int[10][10];

        int result = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];

            result += count[a][b];
            if (a != b) {
                result += count[b][a];
            }

            count[a][b]++;
        }

        return result;
    }
}
