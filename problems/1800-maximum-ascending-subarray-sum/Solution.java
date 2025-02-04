class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int sum = 0;
        int prevNum = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > prevNum) {
                sum += num;
            } else {
                sum = num;
            }

            maxSum = Math.max(maxSum, sum);
            prevNum = num;
        }

        return maxSum;
    }
}
