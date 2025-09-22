class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
        }

        int result = 0;
        int maxFreq = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                result += f;
            } else if (f > maxFreq) {
                result = f;
                maxFreq = f;
            }
        }

        return result;
    }
}
