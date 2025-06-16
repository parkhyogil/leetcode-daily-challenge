class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int num : nums) {
            result = Math.max(result, num - min);
            min = Math.min(min, num);    
        }

        return result == 0 ? -1 : result;
    }
}
