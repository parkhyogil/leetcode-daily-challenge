class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int prevMax = 0;
        int maxScore = 0;

        for (int value : values) {
            maxScore = Math.max(maxScore, prevMax + value);
            prevMax = Math.max(prevMax, value) - 1;
        }

        return maxScore;
    }
}
