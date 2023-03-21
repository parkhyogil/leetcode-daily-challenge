class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;

        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                res += zeroCount;
            } else {
                zeroCount = 0;
            }
        }
        return res;
    }
}
