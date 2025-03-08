class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        int whiteBlocks = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteBlocks++;
            }
        }

        int result = whiteBlocks;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteBlocks++;
            }
            if (blocks.charAt(i - k) == 'W') {
                whiteBlocks--;
            }

            result = Math.min(result, whiteBlocks);
        }

        return result;
    }
}
