class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        Map<Long, Integer>[] count = new HashMap[n];

        int res = 0;

        for (int i = 0; i < n; i++) {
            count[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                res += count[j].getOrDefault(diff, 0);
                count[i].put(diff, 1 + count[i].getOrDefault(diff, 0) + count[j].getOrDefault(diff, 0));
            }
        }

        return res;
    }
}
