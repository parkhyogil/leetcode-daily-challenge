class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = k;
        for (int num : nums) {
            xor ^= num;
        }

        return Integer.bitCount(xor);
    }
}
