class Solution {
    public int longestSquareStreak(int[] nums) {
        int[] length = new int[100001];

        for (int num : nums) {
            length[num] = 1;
        }

        int maxLength = 0;

        for (int i = 2; i * i < length.length; i++) {
            if (length[i * i] > 0) {
                length[i * i] = length[i] + 1;
                maxLength = Math.max(maxLength, length[i * i]);
            }
        }

        return maxLength >= 2 ? maxLength : -1;
    }
}
