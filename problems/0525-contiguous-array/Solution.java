class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? 1 : -1;

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                res = Math.max(res, i - map.get(sum));
            }
        }

        return res;
    }
}
