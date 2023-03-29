class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        
        Arrays.sort(satisfaction);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 1;
            for (int j = i; j < n; j++) {
                sum += satisfaction[j] * count;
                count++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
