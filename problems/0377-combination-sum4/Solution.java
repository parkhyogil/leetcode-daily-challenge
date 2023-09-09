class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        return recur(target, nums, cache);
    }

    private int recur(int t, int[] nums, int[] cache) {
        if (t < 0) {
            return 0;
        }
        if (t == 0) {
            return 1;
        }
        
        if (cache[t] != -1) {
            return cache[t];
        }

        int res = 0;
        for (int num : nums) {
            res += recur(t - num, nums, cache);
        }
        return cache[t] = res;
    }
}
