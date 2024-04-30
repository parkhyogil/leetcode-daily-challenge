class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1 << 11];
        count[0] = 1;
        
        int mask = 0;

        long res = 0;

        for (char c : word.toCharArray()) {
            int bit = 1 << (c - 'a');

            mask ^= bit;

            res += count[mask];
            count[mask]++;

            for (int i = 0; i < 10; i++) {
                res += count[mask ^ (1 << i)];
            }
        }

        return res;
    }
}
