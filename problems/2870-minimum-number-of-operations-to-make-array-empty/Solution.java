class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int f : freq.values()) {
            if (f == 1) {
                return -1;
            }

            res += (f + 2) / 3;
        }
        return res;
    }
}
