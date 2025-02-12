class Solution {
    public int maximumSum(int[] nums) {
        int[] maxValueOfDigitSums = new int[100];
        Arrays.fill(maxValueOfDigitSums, Integer.MIN_VALUE);

        int max = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);

            max = Math.max(max, num + maxValueOfDigitSums[digitSum]);
            maxValueOfDigitSums[digitSum] = Math.max(maxValueOfDigitSums[digitSum], num);
        }

        return max;
    }

    int getDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
