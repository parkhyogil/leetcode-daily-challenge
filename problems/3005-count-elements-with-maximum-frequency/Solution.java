class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        int maxFreq = 0;
        int res = 0;

        for (int num : nums) {
            freq[num]++;

            if (freq[num] > maxFreq) {
                res = freq[num];
                maxFreq = freq[num];
            } else if (freq[num] == maxFreq) {
                res += freq[num];
            }
        }

        return res;
    }
}
