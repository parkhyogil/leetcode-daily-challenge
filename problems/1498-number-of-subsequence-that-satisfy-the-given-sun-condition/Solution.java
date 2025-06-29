class Solution {
    private final int MOD = (int) 1e9 + 7;
    
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;

        int[] pow = new int[n];

        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = pow[i - 1] * 2 % MOD;
        }

        Arrays.sort(nums);

        int result = 0;

        for (int i = 0, j = n - 1; i <= j; i++) {
            while (i <= j && nums[i] + nums[j] > target) {
                j--;
            }

            if (i <= j) {
                result = (result + pow[j - i]) % MOD;
            }
        }

        return result;
    }
}
