public class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = (int) 1e9 + 7;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int[] numberOfSums = new int[totalSum + 1];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                numberOfSums[sum]++;
            }
        }

        long result = 0;
        int count = 0;

        for (int i = 0; i <= totalSum; i++) {
            if (numberOfSums[i] == 0) {
                continue;
            }

            int next = count + numberOfSums[i];

            if (next < left) {
                count = next;
                continue;
            }

            result += i * numberOfSums[i];

            if (count < left) {
                result -= i * (left - 1 - count);
            }

            if (next > right) {
                result -= i * (next - right);
                break;
            }

            count = next;
        }

        return (int) (result % MOD);
    }
}
