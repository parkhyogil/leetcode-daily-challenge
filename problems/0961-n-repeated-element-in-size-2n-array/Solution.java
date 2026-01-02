class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] freq = new int[10001];

        for (int num : nums) {
            if (freq[num] > 0) {
                return num;
            }
            freq[num]++;
        }

        return -1;
    }
}
