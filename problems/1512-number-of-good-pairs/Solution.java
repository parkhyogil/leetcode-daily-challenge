class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];

        int res = 0;
        for (int num : nums) {
            res += count[num];
            count[num]++;
        }
        return res;
    }
}
