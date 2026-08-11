class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        boolean[] contains = new boolean[52];

        for (int i = 0; i < n; i++) {
            contains[nums[i]] = true;
        }

        for (int i = sum; i <= 51; i++) {
            if (!contains[i]) {
                return i;
            }
        }

        return sum;
    }
}
