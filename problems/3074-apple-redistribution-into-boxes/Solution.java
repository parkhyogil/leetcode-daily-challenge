class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;

        for (int v : apple) {
            sum += v;
        }

        Arrays.sort(capacity);

        int result = 0;

        for (int i = capacity.length - 1; i >= 0 && sum > 0; i--) {
            sum -= capacity[i];
            result++;
        }

        return result;
    }
}
