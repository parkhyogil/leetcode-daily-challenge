class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int x : nums) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        return (long) (max - min) * k;
    }
}
