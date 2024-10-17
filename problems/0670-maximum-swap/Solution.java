class Solution {
    public int maximumSwap(int num) {
        int maxValue = num;

        int[] digits = getDigits(num);

        int maxDigitIndex = digits.length - 1;
        
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] > digits[maxDigitIndex]) {
                maxDigitIndex = i;
            } else {
                swap(i, maxDigitIndex, digits);
                maxValue = Math.max(maxValue, parseInt(digits));
                swap(i, maxDigitIndex, digits);
            }
        }

        return maxValue;
    }

    private int parseInt(int[] digits) {
        int result = 0;

        for (int digit : digits) {
            result = result * 10 + digit;
        }

        return result;
    }

    private int[] getDigits(int num) {
        int[] digits = new int[(int) Math.log10(num) + 1];

        int i = digits.length - 1;
        while (num > 0) {
            digits[i--] = num % 10;
            num /= 10;
        }

        return digits;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
