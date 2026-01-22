class Solution {
    public int minimumPairRemoval(int[] nums) {
        int result = 0;

        while (!isSorted(nums)) {
            int n = nums.length;

            int rmIdx = -1;

            for (int i = 0; i < n - 1; i++) {
                if (rmIdx == -1 || nums[i] + nums[i + 1] < nums[rmIdx] + nums[rmIdx + 1]) {
                    rmIdx = i;
                }
            }

            int[] next = new int[n - 1];
            for (int i = 0, j = 0; i < n; i++, j++) {
                if (i == rmIdx) {
                    next[j] = nums[i] + nums[i + 1];
                    i++;
                } else {
                    next[j] = nums[i];
                }
            }

            nums = next;

            result++;
        }

        return result;
    }

    boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
