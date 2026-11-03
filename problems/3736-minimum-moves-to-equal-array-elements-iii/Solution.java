class Solution {
    public int minMoves(int[] nums) {
        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        int result = 0;

        for (int x : nums) {
            result += max - x;
        }

        return result;
    }
}
