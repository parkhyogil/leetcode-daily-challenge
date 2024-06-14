class Solution {
    public int minIncrementForUnique(int[] nums) {
        int[] count = new int[200000];

        for (int num : nums) {
            count[num]++;
        }

        int res = 0;
        int duplicate = 0;

        for (int c : count) {
            res += duplicate;
            duplicate = Math.max(duplicate + c - 1, 0);
        }

        return res;
    }
}
