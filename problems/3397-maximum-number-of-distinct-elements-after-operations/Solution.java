class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        List<Integer> keyList = new ArrayList<>(freq.keySet());

        keyList.sort((a, b) -> a - b);

        int result = 0;
        int prev = Integer.MIN_VALUE;

        for (int key : keyList) {
            int min = Math.max(key - k, prev + 1);
            int max = Math.min(key + k, min + freq.get(key) - 1);

            result += max - min + 1;

            prev = max;
        }

        return result;
    }
}
