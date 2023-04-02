class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;

        int max = 0;
        for (int potion : potions) {
            max = Math.max(max, potion);
        }

        int[] count = new int[max + 1];
        for (int potion : potions) {
            count[potion]++;
        }

        for (int i = max - 1; i > 0; i--) {
            count[i] += count[i + 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long min = (success + spells[i] - 1) / spells[i];
            if (min <= max) {
                res[i] = count[(int) min];
            }
        }
        return res;
    }
}
