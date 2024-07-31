class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        
        int[][] cache = new int[n][shelfWidth + 1];

        return recur(n - 1, shelfWidth, shelfWidth, 0, books, cache);
    }

    private int recur(int idx, int remainingShelfWidth, int shelfWidth, int maxHeight, int[][] books, int[][] cache) {
        if (idx < 0) {
            return maxHeight;
        }

        int width = books[idx][0];
        int height = books[idx][1];

        if (width > remainingShelfWidth) {
            return Integer.MAX_VALUE;
        }

        if (cache[idx][remainingShelfWidth] != 0) {
            return cache[idx][remainingShelfWidth];
        }
        
        maxHeight = Math.max(maxHeight, height);

        int putNewLine = maxHeight + recur(idx - 1, shelfWidth, shelfWidth, 0, books, cache);
        int putNext = recur(idx - 1, remainingShelfWidth - width, shelfWidth, maxHeight, books, cache);

        return cache[idx][remainingShelfWidth] = Math.min(putNewLine, putNext);
    }
}
