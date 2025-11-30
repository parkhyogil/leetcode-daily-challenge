class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;

        int rem = 0;

        for (int num : nums) {
            rem = (rem + num) % p;
        }

        if (rem == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int result = n;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % p;

            if (map.containsKey((sum - rem + p) % p)) {
                result = Math.min(result, i - map.get((sum - rem + p) % p));
            }
            map.put(sum, i);
        }

        return result == n ? -1 : result;
    }
}
