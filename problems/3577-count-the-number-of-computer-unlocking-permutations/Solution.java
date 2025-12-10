class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length, mod = (int) 1e9 + 7;

        long result = 1;

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }

            result = result * i % mod;
        }

        return (int) result;
    }
}
