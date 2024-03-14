class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            res += map.getOrDefault(sum - goal, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
