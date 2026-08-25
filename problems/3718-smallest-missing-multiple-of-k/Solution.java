class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] freq = new int[201];

        for (int x : nums) {
            freq[x]++;
        }

        for (int i = k; i < freq.length; i += k) {
            if (freq[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
