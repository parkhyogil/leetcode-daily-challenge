class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreqValue = -1;
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);

            if (maxFreqValue == -1 || freqMap.get(num) > freqMap.get(maxFreqValue)) {
                maxFreqValue = num;
            }
        }

        if (freqMap.get(maxFreqValue) < n / 2 + 1) {
            return -1;
        }

        int left = 0;
        int right = freqMap.get(maxFreqValue);

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == maxFreqValue) {
                left++;
                right--;
            }

            if (left * 2 > i + 1 && right * 2 > n - (i + 1)) {
                return i;
            }
        }

        return -1;
    }
}
