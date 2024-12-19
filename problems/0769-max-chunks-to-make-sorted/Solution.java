class Solution {
    public int maxChunksToSorted(int[] arr) {
        int numOfChunks = 0;

        int count = 0;
        int currMax = -1;

        for (int val : arr) {
            if (val > currMax) {
                currMax = val;
            }

            count++;
            
            if (count - 1 == currMax) {
                numOfChunks++;
            }
        }

        return numOfChunks;
    }
}
