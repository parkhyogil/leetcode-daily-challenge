class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int len = Math.min(getMaxLength(hBars), getMaxLength(vBars));

        return len * len;
    }

    int getMaxLength(int[] bars) {
        Arrays.sort(bars);
        
        int prev = 1;

        int max = 0;
        for (int i = 0; i < bars.length; i++) {
            if (i == 0 || bars[i] - bars[i - 1] > 1) {
                prev = bars[i] - 1;
            }

            max = Math.max(max, bars[i] - prev + 1);
        }

        return max;
    }
}
