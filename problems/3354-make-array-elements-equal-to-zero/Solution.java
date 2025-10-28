class Solution {
    public int countValidSelections(int[] nums) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            right += num;
        }

        int result = 0;

        for (int num : nums) {
            if (num == 0) {
                int diff = left - right;

                if (diff == 0) {
                    result += 2;
                } else if (Math.abs(diff) == 1) {
                    result++;
                }
            } else {
                left += num;
                right -= num;
            }
        }

        return result;
    }
}
