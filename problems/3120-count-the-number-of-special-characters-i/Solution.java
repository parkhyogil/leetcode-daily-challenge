class Solution {
    public int numberOfSpecialChars(String word) {
        long mask = 0;

        for (char c : word.toCharArray()) {
            if (c <= 'Z') {
                mask |= 1L << (c - 'A');
            } else {
                mask |= 1L << (c - 'a' + 27);
            }
        }

        int result = 0;

        for (char c = 'A'; c <= 'Z'; c++) {
            if ((mask & (1L << (c - 'A'))) > 0 && (mask & (1L << (c + 32 - 'a' + 27))) > 0) {
                result++;
            }
        }

        return result;
    }
}
