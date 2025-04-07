class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        boolean[] canMake = new boolean[target + 1];
        canMake[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                canMake[i] |= canMake[i - num];

                if (canMake[target]) {
                    return true;
                }
            }
        }

        return false;
    }
}
