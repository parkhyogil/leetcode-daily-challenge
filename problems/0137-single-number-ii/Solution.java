class Solution {
    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitCount[i] += ((1 << i) & num) != 0 ? 1 : 0;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % 3 == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
