class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        int result = 0;

        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key - 1)) {
                result = Math.max(result, freqMap.get(key) + freqMap.get(key - 1));
            }
        }

        return result;
    }
}
