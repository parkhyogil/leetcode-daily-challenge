class Solution {
    public int subsetXORSum(int[] nums) {
        return combSum(0, 0, nums);
    }

    private int combSum(int begin, int XORSum, int[] nums) {
        int result = XORSum;

        for (int i = begin; i < nums.length; i++) {
            result += combSum(i + 1, XORSum ^ nums[i], nums);
        }

        return result;
    }
}
