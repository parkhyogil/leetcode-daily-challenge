class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int result = 0;
        int prev = 0, curr = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums.get(i) > nums.get(i - 1)) {
                curr++;
            } else {
                result = Math.max(result, Math.max(curr / 2, Math.min(prev, curr)));

                prev = curr;
                curr = 1;
            }
        }
        result = Math.max(result, Math.max(curr / 2, Math.min(prev, curr)));

        return result;
    }
}
