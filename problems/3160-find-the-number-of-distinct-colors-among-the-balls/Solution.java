class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;

        Map<Integer, Integer> ballColorMap = new HashMap<>();
        Map<Integer, Integer> colorCountMap = new HashMap<>();

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColorMap.containsKey(ball)) {
                int prevColor = ballColorMap.get(ball);
                colorCountMap.merge(prevColor, -1, Integer::sum);

                if (colorCountMap.get(prevColor) == 0) {
                    colorCountMap.remove(prevColor);
                }
            }

            ballColorMap.put(ball, color);
            colorCountMap.merge(color, 1, Integer::sum);

            result[i] = colorCountMap.size();
        }

        return result;
    }
}
