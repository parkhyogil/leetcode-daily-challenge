class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        int[] freq = new int[n];
        int distinctFruits = 0;
        int total = 0;

        int result = 0;

        for (int l = 0, r = 0; r < n; r++) {
            int fruit = fruits[r];

            if (freq[fruit] == 0) {
                distinctFruits++;
            }

            freq[fruit]++;
            total++;

            while (distinctFruits > 2) {
                fruit = fruits[l++];

                total--;
                freq[fruit]--;

                if (freq[fruit] == 0) {
                    distinctFruits--;
                }
            }

            result = Math.max(result, total);
        }

        return result;
    }
}
