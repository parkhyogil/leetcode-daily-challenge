class Solution {
    public int subsetXORSum(int[] nums) {
        return recur(0, 0, nums);
    }

    private int recur(int idx, int xor, int[] nums) {
        int res = xor;

        for (int i = idx; i < nums.length; i++) {
            res += recur(i + 1, xor ^ nums[i], nums);
        }

        return res;
    }
}
