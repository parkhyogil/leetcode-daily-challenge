class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int max = Math.max(nums.length, value);

        int[] freq = new int[max];

        for (int x : nums) {
            freq[(x % value + value) % value]++;
        }

        for (int i = 0; i < max; i++) {
            if (freq[i] == 0) {
                return i;
            }

            if (i + value < max) {
                freq[i + value] += freq[i] - 1;
            }
        }

        return max;
    }
}
