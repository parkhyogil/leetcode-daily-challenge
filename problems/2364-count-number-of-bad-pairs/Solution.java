class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> diffCountMap = new HashMap<>();
        long result = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            int diffCount = diffCountMap.getOrDefault(diff, 0);
            
            result -= diffCount;

            diffCountMap.put(diff, diffCount + 1);
        }

        return result;
    }
}
