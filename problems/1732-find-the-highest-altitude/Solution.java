class Solution {
    public int largestAltitude(int[] gain) {
        int result = 0;
        int prev = 0;

        for (int g : gain) {
            prev += g;
            result = Math.max(result, prev);
        }

        return result;
    }
}
