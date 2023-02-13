class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSumMod = 0;
        int[] modCount = new int[k];
        modCount[0] = 1;

        int res = 0;
        for (int num : nums) {
            prefixSumMod = ((prefixSumMod + num) % k + k) % k;
            res += modCount[prefixSumMod];
            modCount[prefixSumMod]++;
        }
        return res;
    }
}
