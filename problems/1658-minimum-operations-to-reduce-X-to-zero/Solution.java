class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int t = 0;
        for (int v : nums) {
            t += v;
        }

        if (t == x) {
            return n;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int result = n + 1;
        int sum = 0;
        int target = t - x;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum - target)) {
                result = Math.min(result, n - i + map.get(sum - target));
            }

            map.put(sum, i);
        }

        return result > n ? -1 : result;
    }
}
