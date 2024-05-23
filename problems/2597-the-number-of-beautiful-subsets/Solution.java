class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        return recur(0, k, nums, new int[1001]) - 1;
    }

    private int recur(int idx, int k, int[] nums, int[] count) {
        int res = 1;

        for (int i = idx; i < nums.length; i++) {
            if (nums[i] - k > 0 && count[nums[i] - k] > 0) {
                continue;
            }

            count[nums[i]]++;
            res += recur(i + 1, k, nums, count);
            count[nums[i]]--;
        }

        return res;
    }
}
