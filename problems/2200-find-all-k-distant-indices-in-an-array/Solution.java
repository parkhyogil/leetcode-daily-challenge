class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;

        List<Integer> result = new ArrayList<>();

        int[] count = new int[1001];

        for (int i = 0, l = 0, r = 0; i < n; i++) {
            while (r < n && r - i <= k) {
                count[nums[r++]]++;
            }

            if (i - l > k) {
                count[nums[l++]]--;
            }

            if (count[key] > 0) {
                result.add(i);
            }
        }

        return result;
    }
}
